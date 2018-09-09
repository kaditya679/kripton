package sqlite.test03;

import com.abubusoft.kripton.android.sqlite.BindDaoFactory;

/**
 * <p>
 * Represents dao factory interface for Dummy02DataSource.
 * This class expose database interface through Dao attribute.
 * </p>
 *
 * @see Dummy02DataSource
 * @see DaoBean02
 * @see DaoBean02Impl
 * @see Bean01
 */
public interface BindDummy02DaoFactory extends BindDaoFactory {
  /**
   * Retrieve dao DaoBean02.
   *
   * @return dao implementation
   */
  DaoBean02Impl getDaoBean02();
}
