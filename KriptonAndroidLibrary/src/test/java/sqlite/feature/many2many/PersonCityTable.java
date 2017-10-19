package sqlite.feature.many2many;

/**
 * <p>
 * Entity <code>PersonCity</code> is associated to table <code>person_city</code>
 * This class represents table associated to entity.
 * </p>
 *  @see PersonCity
 */
public class PersonCityTable {
  /**
   * Costant represents typeName of table person_city
   */
  public static final String TABLE_NAME = "person_city";

  /**
   * <p>
   * DDL to create table person_city
   * </p>
   *
   * <pre>CREATE TABLE person_city (id INTEGER PRIMARY KEY AUTOINCREMENT, person_id INTEGER NOT NULL, city_id INTEGER NOT NULL, FOREIGN KEY(person_id) REFERENCES persons(id) ON DELETE CASCADE, FOREIGN KEY(city_id) REFERENCES cities(id) ON DELETE CASCADE); CREATE INDEX idx_person_city_person_id ON person_city(person_id); CREATE INDEX idx_person_city_city_id ON person_city(city_id); CREATE UNIQUE INDEX idx_person_city_0 on person_city (person_id, city_id);</pre>
   */
  public static final String CREATE_TABLE_SQL = "CREATE TABLE person_city (id INTEGER PRIMARY KEY AUTOINCREMENT, person_id INTEGER NOT NULL, city_id INTEGER NOT NULL, FOREIGN KEY(person_id) REFERENCES persons(id) ON DELETE CASCADE, FOREIGN KEY(city_id) REFERENCES cities(id) ON DELETE CASCADE); CREATE INDEX idx_person_city_person_id ON person_city(person_id); CREATE INDEX idx_person_city_city_id ON person_city(city_id); CREATE UNIQUE INDEX idx_person_city_0 on person_city (person_id, city_id);";

  /**
   * <p>
   * DDL to drop table person_city
   * </p>
   *
   * <pre> DROP INDEX IF EXISTS idx_person_city_person_id; DROP INDEX IF EXISTS idx_person_city_city_id; DROP INDEX IF EXISTS idx_person_city_1;DROP TABLE IF EXISTS person_city;</pre>
   */
  public static final String DROP_TABLE_SQL = " DROP INDEX IF EXISTS idx_person_city_person_id; DROP INDEX IF EXISTS idx_person_city_city_id; DROP INDEX IF EXISTS idx_person_city_1;DROP TABLE IF EXISTS person_city;";
}
