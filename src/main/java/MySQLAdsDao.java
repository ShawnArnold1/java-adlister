import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.mysql.cj.jdbc.Driver;


public class MySQLAdsDao implements Ads
{
    private Connection connection = null;

    public MySQLAdsDao(Config config)
    {
        try
        {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection
            (
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public List<Ad> all()
    {
        ArrayList<Ad> ads = new ArrayList<>();
        Statement stmt = null;
        try
        {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            while(rs.next()){
                ads.add(createAdFromResults(rs));
            }
            return ads;
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public Ad createAdFromResults(ResultSet rs){
        try{

            return new Ad(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("description")
            );

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Long insert(Ad ad)
    {
        try
        {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }


    private String createInsertQuery(Ad ad)
    {
        return "INSERT INTO ads(user_id, title, description) VALUES "
                + "(" + ad.getUserId() + ", "
                + "'" + ad.getTitle() + "', "
                + "'" + ad.getDescription() + "')";
    }
}