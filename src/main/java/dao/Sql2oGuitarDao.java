package dao;
import models.Guitar;
import models.Note;
import org.sql2o.*;
import java.util.List;

public class Sql2oGuitarDao implements GuitarDao {
    private final Sql2o sql2o;

    public Sql2oGuitarDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Guitar guitar) {
        String sql = "INSERT INTO guitars (type, manufacturer, model, year, imageUrl, color, finish) VALUES (:type, :manufacturer, :model, :year, :imageUrl, :color, :finish)"; //raw sql
        try(Connection con = sql2o.open()){ //try to open a connection
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .bind(guitar) //map my argument onto the query so we can use information from it
                    .executeUpdate() //run it all
                    .getKey(); //int id is now the row number (row “key”) of db
            guitar.setId(id); //update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!
        }
    }

    @Override
    public List<Guitar> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM guitars") //raw sql
                    .executeAndFetch(Guitar.class); //fetch a list
        }
    }

    @Override
    public Guitar findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM guitars WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Guitar.class); //fetch an individual item
        }
    }

    @Override
    public void update(int id, String type, String manufacturer, String model, int year, String imageUrl, String color, String finish){
        String sql = "UPDATE categories SET (type, manufacturer, model, year, imageUrl, color, finish) = (:type, :manufacturer, :model, :year, :imageUrl, :color, :finish) WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("type", type)
                    .addParameter("manufacturer", manufacturer)
                    .addParameter("model", model)
                    .addParameter("year", year)
                    .addParameter("imageUrl", imageUrl)
                    .addParameter("color", color)
                    .addParameter("finish", finish)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from guitars WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Note> getAllNotesByGuitarId(int guitarId) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM notes WHERE guitarId = :guitarId")
                    .addParameter("guitarId", guitarId)
                    .executeAndFetch(Note.class);
        }
    }

}
