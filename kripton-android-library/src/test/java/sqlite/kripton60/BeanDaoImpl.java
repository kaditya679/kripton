/*******************************************************************************
 * Copyright 2018 Francesco Benincasa (info@abubusoft.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package sqlite.kripton60;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.abubusoft.kripton.BinderUtils;
import com.abubusoft.kripton.KriptonBinder;
import com.abubusoft.kripton.KriptonJsonContext;
import com.abubusoft.kripton.android.Logger;
import com.abubusoft.kripton.android.sqlite.Dao;
import com.abubusoft.kripton.android.sqlite.KriptonContentValues;
import com.abubusoft.kripton.android.sqlite.KriptonDatabaseWrapper;
import com.abubusoft.kripton.android.sqlite.OnReadBeanListener;
import com.abubusoft.kripton.android.sqlite.OnReadCursorListener;
import com.abubusoft.kripton.android.sqlite.SQLContext;
import com.abubusoft.kripton.common.CalendarUtils;
import com.abubusoft.kripton.common.CollectionUtils;
import com.abubusoft.kripton.common.CurrencyUtils;
import com.abubusoft.kripton.common.DateUtils;
import com.abubusoft.kripton.common.EnumUtils;
import com.abubusoft.kripton.common.KriptonByteArrayOutputStream;
import com.abubusoft.kripton.common.LocaleUtils;
import com.abubusoft.kripton.common.SQLTimeUtils;
import com.abubusoft.kripton.common.StringUtils;
import com.abubusoft.kripton.common.TimeZoneUtils;
import com.abubusoft.kripton.common.Triple;
import com.abubusoft.kripton.common.UrlUtils;
import com.abubusoft.kripton.exception.KriptonRuntimeException;
import com.abubusoft.kripton.persistence.JacksonWrapperParser;
import com.abubusoft.kripton.persistence.JacksonWrapperSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * DAO implementation for entity <code>Bean</code>, based on interface <code>BeanDao</code>
 * </p>.
 *
 * @see Bean
 * @see BeanDao
 * @see BeanTable
 */
public class BeanDaoImpl extends Dao implements BeanDao {
  
  /** The delete prepared statement 0. */
  private static SQLiteStatement deletePreparedStatement0;

  /** The delete prepared statement 1. */
  private static SQLiteStatement deletePreparedStatement1;

  /** The delete prepared statement 2. */
  private static SQLiteStatement deletePreparedStatement2;

  /** The delete prepared statement 3. */
  private static SQLiteStatement deletePreparedStatement3;

  /** The delete array bean type prepared statement 4. */
  private static SQLiteStatement deleteArrayBeanTypePreparedStatement4;

  /** The delete array long prepared statement 5. */
  private static SQLiteStatement deleteArrayLongPreparedStatement5;

  /** The delete array long type prepared statement 6. */
  private static SQLiteStatement deleteArrayLongTypePreparedStatement6;

  /** The delete byte prepared statement 7. */
  private static SQLiteStatement deleteBytePreparedStatement7;

  /** The delete byte type prepared statement 8. */
  private static SQLiteStatement deleteByteTypePreparedStatement8;

  /** The delete calendar prepared statement 9. */
  private static SQLiteStatement deleteCalendarPreparedStatement9;

  /** The delete char prepared statement 10. */
  private static SQLiteStatement deleteCharPreparedStatement10;

  /** The delete char type prepared statement 11. */
  private static SQLiteStatement deleteCharTypePreparedStatement11;

  /** The delete currency prepared statement 12. */
  private static SQLiteStatement deleteCurrencyPreparedStatement12;

  /** The delete date prepared statement 13. */
  private static SQLiteStatement deleteDatePreparedStatement13;

  /** The delete double prepared statement 14. */
  private static SQLiteStatement deleteDoublePreparedStatement14;

  /** The delete double type prepared statement 15. */
  private static SQLiteStatement deleteDoubleTypePreparedStatement15;

  /** The delete enum type prepared statement 16. */
  private static SQLiteStatement deleteEnumTypePreparedStatement16;

  /** The delete float prepared statement 17. */
  private static SQLiteStatement deleteFloatPreparedStatement17;

  /** The delete float type prepared statement 18. */
  private static SQLiteStatement deleteFloatTypePreparedStatement18;

  /** The delete int prepared statement 19. */
  private static SQLiteStatement deleteIntPreparedStatement19;

  /** The delete int type prepared statement 20. */
  private static SQLiteStatement deleteIntTypePreparedStatement20;

  /** The delete list long prepared statement 21. */
  private static SQLiteStatement deleteListLongPreparedStatement21;

  /** The delete locale prepared statement 22. */
  private static SQLiteStatement deleteLocalePreparedStatement22;

  /** The delete long prepared statement 23. */
  private static SQLiteStatement deleteLongPreparedStatement23;

  /** The delete long type prepared statement 24. */
  private static SQLiteStatement deleteLongTypePreparedStatement24;

  /** The delete short prepared statement 25. */
  private static SQLiteStatement deleteShortPreparedStatement25;

  /** The delete short type prepared statement 26. */
  private static SQLiteStatement deleteShortTypePreparedStatement26;

  /** The delete string prepared statement 27. */
  private static SQLiteStatement deleteStringPreparedStatement27;

  /** The delete time prepared statement 28. */
  private static SQLiteStatement deleteTimePreparedStatement28;

  /** The delete time zone prepared statement 29. */
  private static SQLiteStatement deleteTimeZonePreparedStatement29;

  /** The delete URL prepared statement 30. */
  private static SQLiteStatement deleteURLPreparedStatement30;

  /** The insert prepared statement 31. */
  private static SQLiteStatement insertPreparedStatement31;

  /** The insert prepared statement 32. */
  private static SQLiteStatement insertPreparedStatement32;

  /** The insert prepared statement 33. */
  private static SQLiteStatement insertPreparedStatement33;

  /** The insert prepared statement 34. */
  private static SQLiteStatement insertPreparedStatement34;

  /** The insert prepared statement 35. */
  private static SQLiteStatement insertPreparedStatement35;

  /** The insert array bean type prepared statement 36. */
  private static SQLiteStatement insertArrayBeanTypePreparedStatement36;

  /** The insert array long prepared statement 37. */
  private static SQLiteStatement insertArrayLongPreparedStatement37;

  /** The insert array long type prepared statement 38. */
  private static SQLiteStatement insertArrayLongTypePreparedStatement38;

  /** The insert byte prepared statement 39. */
  private static SQLiteStatement insertBytePreparedStatement39;

  /** The insert byte type prepared statement 40. */
  private static SQLiteStatement insertByteTypePreparedStatement40;

  /** The insert calendar prepared statement 41. */
  private static SQLiteStatement insertCalendarPreparedStatement41;

  /** The insert char prepared statement 42. */
  private static SQLiteStatement insertCharPreparedStatement42;

  /** The insert char type prepared statement 43. */
  private static SQLiteStatement insertCharTypePreparedStatement43;

  /** The insert currency prepared statement 44. */
  private static SQLiteStatement insertCurrencyPreparedStatement44;

  /** The insert date prepared statement 45. */
  private static SQLiteStatement insertDatePreparedStatement45;

  /** The insert double prepared statement 46. */
  private static SQLiteStatement insertDoublePreparedStatement46;

  /** The insert double type prepared statement 47. */
  private static SQLiteStatement insertDoubleTypePreparedStatement47;

  /** The insert enum type prepared statement 48. */
  private static SQLiteStatement insertEnumTypePreparedStatement48;

  /** The insert float prepared statement 49. */
  private static SQLiteStatement insertFloatPreparedStatement49;

  /** The insert float type prepared statement 50. */
  private static SQLiteStatement insertFloatTypePreparedStatement50;

  /** The insert int prepared statement 51. */
  private static SQLiteStatement insertIntPreparedStatement51;

  /** The insert int type prepared statement 52. */
  private static SQLiteStatement insertIntTypePreparedStatement52;

  /** The insert list long prepared statement 53. */
  private static SQLiteStatement insertListLongPreparedStatement53;

  /** The insert locale prepared statement 54. */
  private static SQLiteStatement insertLocalePreparedStatement54;

  /** The insert long prepared statement 55. */
  private static SQLiteStatement insertLongPreparedStatement55;

  /** The insert long type prepared statement 56. */
  private static SQLiteStatement insertLongTypePreparedStatement56;

  /** The insert short prepared statement 57. */
  private static SQLiteStatement insertShortPreparedStatement57;

  /** The insert short type prepared statement 58. */
  private static SQLiteStatement insertShortTypePreparedStatement58;

  /** The insert string prepared statement 59. */
  private static SQLiteStatement insertStringPreparedStatement59;

  /** The insert time prepared statement 60. */
  private static SQLiteStatement insertTimePreparedStatement60;

  /** The insert time zone prepared statement 61. */
  private static SQLiteStatement insertTimeZonePreparedStatement61;

  /** The insert URL prepared statement 62. */
  private static SQLiteStatement insertURLPreparedStatement62;

  /** The Constant SELECT_LIST_SQL1. */
  private static final String SELECT_LIST_SQL1 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE id = ?";

  /** The Constant SELECT_ONE_SQL2. */
  private static final String SELECT_ONE_SQL2 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean";

  /** The Constant SELECT_ONE_SQL3. */
  private static final String SELECT_ONE_SQL3 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_big_decimal=?";

  /** The Constant SELECT_ONE_SQL4. */
  private static final String SELECT_ONE_SQL4 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_big_decimal=?";

  /** The Constant SELECT_ONE_SQL5. */
  private static final String SELECT_ONE_SQL5 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_bool_type=?";

  /** The Constant SELECT_ONE_SQL6. */
  private static final String SELECT_ONE_SQL6 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_bool=?";

  /** The Constant SELECT_ONE_SQL7. */
  private static final String SELECT_ONE_SQL7 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE id = ?";

  /** The Constant SELECT_ONE_SQL8. */
  private static final String SELECT_ONE_SQL8 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE id = ?";

  /** The Constant SELECT_ONE_ARRAY_BEAN_TYPE_SQL9. */
  private static final String SELECT_ONE_ARRAY_BEAN_TYPE_SQL9 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_bean_array=?";

  /** The Constant SELECT_ONE_ARRAY_LONG_SQL10. */
  private static final String SELECT_ONE_ARRAY_LONG_SQL10 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_long_array=?";

  /** The Constant SELECT_ONE_ARRAY_LONG_TYPE_SQL11. */
  private static final String SELECT_ONE_ARRAY_LONG_TYPE_SQL11 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_long_type_array=?";

  /** The Constant SELECT_ONE_BYTE_SQL12. */
  private static final String SELECT_ONE_BYTE_SQL12 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_byte=?";

  /** The Constant SELECT_ONE_BYTE_TYPE_SQL13. */
  private static final String SELECT_ONE_BYTE_TYPE_SQL13 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_byte_type=?";

  /** The Constant SELECT_ONE_CALENDAR_SQL14. */
  private static final String SELECT_ONE_CALENDAR_SQL14 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_calendar=?";

  /** The Constant SELECT_ONE_CHAR_SQL15. */
  private static final String SELECT_ONE_CHAR_SQL15 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_char_type=?";

  /** The Constant SELECT_ONE_CHAR_TYPE_SQL16. */
  private static final String SELECT_ONE_CHAR_TYPE_SQL16 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_char_type=?";

  /** The Constant SELECT_ONE_CURRENCYE_SQL17. */
  private static final String SELECT_ONE_CURRENCYE_SQL17 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_currency=?";

  /** The Constant SELECT_ONE_DATE_SQL18. */
  private static final String SELECT_ONE_DATE_SQL18 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_date=?";

  /** The Constant SELECT_ONE_DOUBLE_SQL19. */
  private static final String SELECT_ONE_DOUBLE_SQL19 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_double=?";

  /** The Constant SELECT_ONE_DOUBLE_TYPE_SQL20. */
  private static final String SELECT_ONE_DOUBLE_TYPE_SQL20 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_double_type=?";

  /** The Constant SELECT_ONE_ENUM_TYPE_SQL21. */
  private static final String SELECT_ONE_ENUM_TYPE_SQL21 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_enum_type=?";

  /** The Constant SELECT_ONE_FLOAT_SQL22. */
  private static final String SELECT_ONE_FLOAT_SQL22 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_float=?";

  /** The Constant SELECT_ONE_FLOAT_TYPE_SQL23. */
  private static final String SELECT_ONE_FLOAT_TYPE_SQL23 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_float_type=?";

  /** The Constant SELECT_ONE_INT_SQL24. */
  private static final String SELECT_ONE_INT_SQL24 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_int=?";

  /** The Constant SELECT_ONE_INT_TYPE_SQL25. */
  private static final String SELECT_ONE_INT_TYPE_SQL25 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_int_type=?";

  /** The Constant SELECT_ONE_LIST_LONG_SQL26. */
  private static final String SELECT_ONE_LIST_LONG_SQL26 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_long_list=?";

  /** The Constant SELECT_ONE_LOCALE_SQL27. */
  private static final String SELECT_ONE_LOCALE_SQL27 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_locale=?";

  /** The Constant SELECT_ONE_LONG_SQL28. */
  private static final String SELECT_ONE_LONG_SQL28 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_long=?";

  /** The Constant SELECT_ONE_LONG_TYPE_SQL29. */
  private static final String SELECT_ONE_LONG_TYPE_SQL29 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_long_type=?";

  /** The Constant SELECT_ONE_SHORT_SQL30. */
  private static final String SELECT_ONE_SHORT_SQL30 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_short=?";

  /** The Constant SELECT_ONE_SHORT_TYPE_SQL31. */
  private static final String SELECT_ONE_SHORT_TYPE_SQL31 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_short_type=?";

  /** The Constant SELECT_ONE_STRING_SQL32. */
  private static final String SELECT_ONE_STRING_SQL32 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_string=?";

  /** The Constant SELECT_ONE_TIME_SQL33. */
  private static final String SELECT_ONE_TIME_SQL33 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_time=?";

  /** The Constant SELECT_ONE_TIME_ZONE_SQL34. */
  private static final String SELECT_ONE_TIME_ZONE_SQL34 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_time_zone=?";

  /** The Constant SELECT_ONE_U_R_L_SQL35. */
  private static final String SELECT_ONE_U_R_L_SQL35 = "SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_url=?";

  /** The Constant SELECT_VALUE_BOOL_SQL36. */
  private static final String SELECT_VALUE_BOOL_SQL36 = "SELECT value_bool FROM bean";

  /** The Constant SELECT_VALUE_BOOL_TYPE_SQL37. */
  private static final String SELECT_VALUE_BOOL_TYPE_SQL37 = "SELECT value_bool_type FROM bean";

  /** The Constant SELECT_VALUE_BYTE_SQL38. */
  private static final String SELECT_VALUE_BYTE_SQL38 = "SELECT value_byte FROM bean";

  /** The Constant SELECT_VALUE_BYTE_TYPE_SQL39. */
  private static final String SELECT_VALUE_BYTE_TYPE_SQL39 = "SELECT value_byte_type FROM bean";

  /** The Constant SELECT_VALUE_CHAR_SQL40. */
  private static final String SELECT_VALUE_CHAR_SQL40 = "SELECT value_char FROM bean";

  /** The Constant SELECT_VALUE_CHAR_TYPE_SQL41. */
  private static final String SELECT_VALUE_CHAR_TYPE_SQL41 = "SELECT value_char_type FROM bean";

  /** The Constant SELECT_VALUE_DOUBLE_SQL42. */
  private static final String SELECT_VALUE_DOUBLE_SQL42 = "SELECT value_double FROM bean";

  /** The Constant SELECT_VALUE_DOUBLE_TYPE_SQL43. */
  private static final String SELECT_VALUE_DOUBLE_TYPE_SQL43 = "SELECT value_double_type FROM bean";

  /** The Constant SELECT_VALUE_FLOAT_SQL44. */
  private static final String SELECT_VALUE_FLOAT_SQL44 = "SELECT value_float FROM bean";

  /** The Constant SELECT_VALUE_FLOAT_TYPE_SQL45. */
  private static final String SELECT_VALUE_FLOAT_TYPE_SQL45 = "SELECT value_float_type FROM bean";

  /** The Constant SELECT_VALUE_INT_SQL46. */
  private static final String SELECT_VALUE_INT_SQL46 = "SELECT value_int FROM bean";

  /** The Constant SELECT_VALUE_INT_TYPE_SQL47. */
  private static final String SELECT_VALUE_INT_TYPE_SQL47 = "SELECT value_int_type FROM bean";

  /** The Constant SELECT_VALUE_LONG_SQL48. */
  private static final String SELECT_VALUE_LONG_SQL48 = "SELECT value_long FROM bean";

  /** The Constant SELECT_VALUE_LONG_TYPE_SQL49. */
  private static final String SELECT_VALUE_LONG_TYPE_SQL49 = "SELECT value_long_type FROM bean";

  /** The Constant SELECT_VALUE_SHORT_SQL50. */
  private static final String SELECT_VALUE_SHORT_SQL50 = "SELECT value_short FROM bean";

  /** The Constant SELECT_VALUE_SHORT_TYPE_SQL51. */
  private static final String SELECT_VALUE_SHORT_TYPE_SQL51 = "SELECT value_short_type FROM bean";

  /** The Constant SELECT_VALUE_STRING_SQL52. */
  private static final String SELECT_VALUE_STRING_SQL52 = "SELECT value_string FROM bean";

  /** The update one prepared statement 63. */
  private static SQLiteStatement updateOnePreparedStatement63;

  /** The update one prepared statement 64. */
  private static SQLiteStatement updateOnePreparedStatement64;

  /** The update one prepared statement 65. */
  private static SQLiteStatement updateOnePreparedStatement65;

  /** The update one prepared statement 66. */
  private static SQLiteStatement updateOnePreparedStatement66;

  /** The update one prepared statement 67. */
  private static SQLiteStatement updateOnePreparedStatement67;

  /** The update one prepared statement 68. */
  private static SQLiteStatement updateOnePreparedStatement68;

  /** The update one array bean prepared statement 69. */
  private static SQLiteStatement updateOneArrayBeanPreparedStatement69;

  /** The update one array long prepared statement 70. */
  private static SQLiteStatement updateOneArrayLongPreparedStatement70;

  /** The update one array long type prepared statement 71. */
  private static SQLiteStatement updateOneArrayLongTypePreparedStatement71;

  /** The update one byte prepared statement 72. */
  private static SQLiteStatement updateOneBytePreparedStatement72;

  /** The update one byte type prepared statement 73. */
  private static SQLiteStatement updateOneByteTypePreparedStatement73;

  /** The update one calendar prepared statement 74. */
  private static SQLiteStatement updateOneCalendarPreparedStatement74;

  /** The update one char prepared statement 75. */
  private static SQLiteStatement updateOneCharPreparedStatement75;

  /** The update one char type prepared statement 76. */
  private static SQLiteStatement updateOneCharTypePreparedStatement76;

  /** The update one currency prepared statement 77. */
  private static SQLiteStatement updateOneCurrencyPreparedStatement77;

  /** The update one date prepared statement 78. */
  private static SQLiteStatement updateOneDatePreparedStatement78;

  /** The update one double prepared statement 79. */
  private static SQLiteStatement updateOneDoublePreparedStatement79;

  /** The update one double type prepared statement 80. */
  private static SQLiteStatement updateOneDoubleTypePreparedStatement80;

  /** The update one enum type prepared statement 81. */
  private static SQLiteStatement updateOneEnumTypePreparedStatement81;

  /** The update one float prepared statement 82. */
  private static SQLiteStatement updateOneFloatPreparedStatement82;

  /** The update one float type prepared statement 83. */
  private static SQLiteStatement updateOneFloatTypePreparedStatement83;

  /** The update one int prepared statement 84. */
  private static SQLiteStatement updateOneIntPreparedStatement84;

  /** The update one int type prepared statement 85. */
  private static SQLiteStatement updateOneIntTypePreparedStatement85;

  /** The update one list long prepared statement 86. */
  private static SQLiteStatement updateOneListLongPreparedStatement86;

  /** The update one locale prepared statement 87. */
  private static SQLiteStatement updateOneLocalePreparedStatement87;

  /** The update one long prepared statement 88. */
  private static SQLiteStatement updateOneLongPreparedStatement88;

  /** The update one long type prepared statement 89. */
  private static SQLiteStatement updateOneLongTypePreparedStatement89;

  /** The update one short prepared statement 90. */
  private static SQLiteStatement updateOneShortPreparedStatement90;

  /** The update one short type prepared statement 91. */
  private static SQLiteStatement updateOneShortTypePreparedStatement91;

  /** The update one string prepared statement 92. */
  private static SQLiteStatement updateOneStringPreparedStatement92;

  /** The update one time prepared statement 93. */
  private static SQLiteStatement updateOneTimePreparedStatement93;

  /** The update one time zone prepared statement 94. */
  private static SQLiteStatement updateOneTimeZonePreparedStatement94;

  /** The update one URL prepared statement 95. */
  private static SQLiteStatement updateOneURLPreparedStatement95;

  /** BeanBindMap. */
  private BeanBindMap beanBindMap = BinderUtils.mapperFor(Bean.class);

  /**
   * Instantiates a new bean dao impl.
   *
   * @param context the context
   */
  public BeanDaoImpl(SQLContext context) {
    super(context);
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_big_decimal=${valueBigDecimal}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueBigDecimal}</dt><dd>is mapped to method's parameter <strong>valueBigDecimal</strong></dd>
   * </dl>.
   *
   * @param valueBigDecimal 	is used as where parameter <strong>${valueBigDecimal}</strong>
   * @return number of deleted records
   */
  @Override
  public long delete(BigDecimal valueBigDecimal) {
    if (deletePreparedStatement0==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_big_decimal=?";
      deletePreparedStatement0 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deletePreparedStatement0);
    _contentValues.addWhereArgs((valueBigDecimal==null?"":valueBigDecimal.toPlainString()));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_big_decimal=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deletePreparedStatement0, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_big_decimal=${valueBigDecimal}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueBigDecimal}</dt><dd>is mapped to method's parameter <strong>valueBigDecimal</strong></dd>
   * </dl>.
   *
   * @param valueBigDecimal 	is used as where parameter <strong>${valueBigDecimal}</strong>
   * @return number of deleted records
   */
  @Override
  public long delete(BigInteger valueBigDecimal) {
    if (deletePreparedStatement1==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_big_decimal=?";
      deletePreparedStatement1 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deletePreparedStatement1);
    _contentValues.addWhereArgs((valueBigDecimal==null?"":valueBigDecimal.toString()));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_big_decimal=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deletePreparedStatement1, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_bool_type=${valueBoolType}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueBoolType}</dt><dd>is mapped to method's parameter <strong>valueBoolType</strong></dd>
   * </dl>.
   *
   * @param valueBoolType 	is used as where parameter <strong>${valueBoolType}</strong>
   * @return number of deleted records
   */
  @Override
  public long delete(boolean valueBoolType) {
    if (deletePreparedStatement2==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_bool_type=?";
      deletePreparedStatement2 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deletePreparedStatement2);
    _contentValues.addWhereArgs(String.valueOf(valueBoolType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_bool_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deletePreparedStatement2, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_bool=${valueBool}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueBool}</dt><dd>is mapped to method's parameter <strong>valueBool</strong></dd>
   * </dl>.
   *
   * @param valueBool 	is used as where parameter <strong>${valueBool}</strong>
   * @return number of deleted records
   */
  @Override
  public long delete(Boolean valueBool) {
    if (deletePreparedStatement3==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_bool=?";
      deletePreparedStatement3 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deletePreparedStatement3);
    _contentValues.addWhereArgs((valueBool==null?"":String.valueOf(valueBool)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_bool=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deletePreparedStatement3, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_bean_array=${valueBeanArray}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueBeanArray}</dt><dd>is mapped to method's parameter <strong>valueBeanArray</strong></dd>
   * </dl>.
   *
   * @param valueBeanArray 	is used as where parameter <strong>${valueBeanArray}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteArrayBeanType(Bean[] valueBeanArray) {
    if (deleteArrayBeanTypePreparedStatement4==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_bean_array=?";
      deleteArrayBeanTypePreparedStatement4 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteArrayBeanTypePreparedStatement4);
    _contentValues.addWhereArgs((valueBeanArray==null?"":new String(serializer1(valueBeanArray),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_bean_array=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteArrayBeanTypePreparedStatement4, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_long_array=${valueLongArray}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueLongArray}</dt><dd>is mapped to method's parameter <strong>valueLongArray</strong></dd>
   * </dl>.
   *
   * @param valueLongArray 	is used as where parameter <strong>${valueLongArray}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteArrayLong(Long[] valueLongArray) {
    if (deleteArrayLongPreparedStatement5==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_long_array=?";
      deleteArrayLongPreparedStatement5 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteArrayLongPreparedStatement5);
    _contentValues.addWhereArgs((valueLongArray==null?"":new String(serializer2(valueLongArray),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_long_array=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteArrayLongPreparedStatement5, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_long_type_array=${valueLongTypeArray}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueLongTypeArray}</dt><dd>is mapped to method's parameter <strong>valueLongTypeArray</strong></dd>
   * </dl>.
   *
   * @param valueLongTypeArray 	is used as where parameter <strong>${valueLongTypeArray}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteArrayLongType(long[] valueLongTypeArray) {
    if (deleteArrayLongTypePreparedStatement6==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_long_type_array=?";
      deleteArrayLongTypePreparedStatement6 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteArrayLongTypePreparedStatement6);
    _contentValues.addWhereArgs((valueLongTypeArray==null?"":new String(serializer3(valueLongTypeArray),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_long_type_array=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteArrayLongTypePreparedStatement6, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_byte=${valueByte}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueByte}</dt><dd>is mapped to method's parameter <strong>valueByte</strong></dd>
   * </dl>.
   *
   * @param valueByte 	is used as where parameter <strong>${valueByte}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteByte(Byte valueByte) {
    if (deleteBytePreparedStatement7==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_byte=?";
      deleteBytePreparedStatement7 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteBytePreparedStatement7);
    _contentValues.addWhereArgs((valueByte==null?"":String.valueOf(valueByte)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_byte=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteBytePreparedStatement7, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_byte_type=${valueByteType}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueByteType}</dt><dd>is mapped to method's parameter <strong>valueByteType</strong></dd>
   * </dl>.
   *
   * @param valueByteType 	is used as where parameter <strong>${valueByteType}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteByteType(boolean valueByteType) {
    if (deleteByteTypePreparedStatement8==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_byte_type=?";
      deleteByteTypePreparedStatement8 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteByteTypePreparedStatement8);
    _contentValues.addWhereArgs(String.valueOf(valueByteType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_byte_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteByteTypePreparedStatement8, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_calendar=${valueCalendar}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueCalendar}</dt><dd>is mapped to method's parameter <strong>valueCalendar</strong></dd>
   * </dl>.
   *
   * @param valueCalendar 	is used as where parameter <strong>${valueCalendar}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteCalendar(Date valueCalendar) {
    if (deleteCalendarPreparedStatement9==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_calendar=?";
      deleteCalendarPreparedStatement9 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteCalendarPreparedStatement9);
    _contentValues.addWhereArgs((valueCalendar==null?"":DateUtils.write(valueCalendar)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_calendar=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteCalendarPreparedStatement9, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_char_type=${valueChar}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueChar}</dt><dd>is mapped to method's parameter <strong>valueChar</strong></dd>
   * </dl>.
   *
   * @param valueChar 	is used as where parameter <strong>${valueChar}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteChar(Character valueChar) {
    if (deleteCharPreparedStatement10==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_char_type=?";
      deleteCharPreparedStatement10 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteCharPreparedStatement10);
    _contentValues.addWhereArgs((valueChar==null?"":String.valueOf(valueChar)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_char_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteCharPreparedStatement10, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_char_type=${valueCharType}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueCharType}</dt><dd>is mapped to method's parameter <strong>valueCharType</strong></dd>
   * </dl>.
   *
   * @param valueCharType 	is used as where parameter <strong>${valueCharType}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteCharType(char valueCharType) {
    if (deleteCharTypePreparedStatement11==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_char_type=?";
      deleteCharTypePreparedStatement11 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteCharTypePreparedStatement11);
    _contentValues.addWhereArgs(String.valueOf(valueCharType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_char_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteCharTypePreparedStatement11, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_currency=${valueCurrency}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueCurrency}</dt><dd>is mapped to method's parameter <strong>valueCurrency</strong></dd>
   * </dl>.
   *
   * @param valueCurrency 	is used as where parameter <strong>${valueCurrency}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteCurrency(Currency valueCurrency) {
    if (deleteCurrencyPreparedStatement12==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_currency=?";
      deleteCurrencyPreparedStatement12 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteCurrencyPreparedStatement12);
    _contentValues.addWhereArgs((valueCurrency==null?"":CurrencyUtils.write(valueCurrency)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_currency=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteCurrencyPreparedStatement12, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_date=${valueDate}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueDate}</dt><dd>is mapped to method's parameter <strong>valueDate</strong></dd>
   * </dl>.
   *
   * @param valueDate 	is used as where parameter <strong>${valueDate}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteDate(Date valueDate) {
    if (deleteDatePreparedStatement13==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_date=?";
      deleteDatePreparedStatement13 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteDatePreparedStatement13);
    _contentValues.addWhereArgs((valueDate==null?"":DateUtils.write(valueDate)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_date=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteDatePreparedStatement13, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_double=${valueDouble}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueDouble}</dt><dd>is mapped to method's parameter <strong>valueDouble</strong></dd>
   * </dl>.
   *
   * @param valueDouble 	is used as where parameter <strong>${valueDouble}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteDouble(Double valueDouble) {
    if (deleteDoublePreparedStatement14==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_double=?";
      deleteDoublePreparedStatement14 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteDoublePreparedStatement14);
    _contentValues.addWhereArgs((valueDouble==null?"":String.valueOf(valueDouble)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_double=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteDoublePreparedStatement14, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_double_type=${valueDoubleType}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueDoubleType}</dt><dd>is mapped to method's parameter <strong>valueDoubleType</strong></dd>
   * </dl>.
   *
   * @param valueDoubleType 	is used as where parameter <strong>${valueDoubleType}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteDoubleType(double valueDoubleType) {
    if (deleteDoubleTypePreparedStatement15==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_double_type=?";
      deleteDoubleTypePreparedStatement15 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteDoubleTypePreparedStatement15);
    _contentValues.addWhereArgs(String.valueOf(valueDoubleType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_double_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteDoubleTypePreparedStatement15, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_enum_type=${valueEnumType}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueEnumType}</dt><dd>is mapped to method's parameter <strong>valueEnumType</strong></dd>
   * </dl>.
   *
   * @param valueEnumType 	is used as where parameter <strong>${valueEnumType}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteEnumType(EnumType valueEnumType) {
    if (deleteEnumTypePreparedStatement16==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_enum_type=?";
      deleteEnumTypePreparedStatement16 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteEnumTypePreparedStatement16);
    _contentValues.addWhereArgs((valueEnumType==null?"":EnumUtils.write(valueEnumType)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_enum_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteEnumTypePreparedStatement16, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_float=${valueFloat}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueFloat}</dt><dd>is mapped to method's parameter <strong>valueFloat</strong></dd>
   * </dl>.
   *
   * @param valueFloat 	is used as where parameter <strong>${valueFloat}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteFloat(Float valueFloat) {
    if (deleteFloatPreparedStatement17==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_float=?";
      deleteFloatPreparedStatement17 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteFloatPreparedStatement17);
    _contentValues.addWhereArgs((valueFloat==null?"":String.valueOf(valueFloat)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_float=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteFloatPreparedStatement17, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_float_type=${valueFloatType}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueFloatType}</dt><dd>is mapped to method's parameter <strong>valueFloatType</strong></dd>
   * </dl>.
   *
   * @param valueFloatType 	is used as where parameter <strong>${valueFloatType}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteFloatType(float valueFloatType) {
    if (deleteFloatTypePreparedStatement18==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_float_type=?";
      deleteFloatTypePreparedStatement18 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteFloatTypePreparedStatement18);
    _contentValues.addWhereArgs(String.valueOf(valueFloatType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_float_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteFloatTypePreparedStatement18, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_int=${valueInt}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueInt}</dt><dd>is mapped to method's parameter <strong>valueInt</strong></dd>
   * </dl>.
   *
   * @param valueInt 	is used as where parameter <strong>${valueInt}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteInt(Integer valueInt) {
    if (deleteIntPreparedStatement19==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_int=?";
      deleteIntPreparedStatement19 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteIntPreparedStatement19);
    _contentValues.addWhereArgs((valueInt==null?"":String.valueOf(valueInt)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_int=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteIntPreparedStatement19, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_int_type=${valueIntType}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueIntType}</dt><dd>is mapped to method's parameter <strong>valueIntType</strong></dd>
   * </dl>.
   *
   * @param valueIntType 	is used as where parameter <strong>${valueIntType}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteIntType(int valueIntType) {
    if (deleteIntTypePreparedStatement20==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_int_type=?";
      deleteIntTypePreparedStatement20 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteIntTypePreparedStatement20);
    _contentValues.addWhereArgs(String.valueOf(valueIntType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_int_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteIntTypePreparedStatement20, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_long_list=${valueLongList}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueLongList}</dt><dd>is mapped to method's parameter <strong>valueLongList</strong></dd>
   * </dl>.
   *
   * @param valueLongList 	is used as where parameter <strong>${valueLongList}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteListLong(LinkedList<Long> valueLongList) {
    if (deleteListLongPreparedStatement21==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_long_list=?";
      deleteListLongPreparedStatement21 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteListLongPreparedStatement21);
    _contentValues.addWhereArgs((valueLongList==null?"":new String(serializer4(valueLongList),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_long_list=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteListLongPreparedStatement21, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_locale=${valueLocale}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueLocale}</dt><dd>is mapped to method's parameter <strong>valueLocale</strong></dd>
   * </dl>.
   *
   * @param valueLocale 	is used as where parameter <strong>${valueLocale}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteLocale(Date valueLocale) {
    if (deleteLocalePreparedStatement22==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_locale=?";
      deleteLocalePreparedStatement22 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteLocalePreparedStatement22);
    _contentValues.addWhereArgs((valueLocale==null?"":DateUtils.write(valueLocale)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_locale=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteLocalePreparedStatement22, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_long=${valueLong}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueLong}</dt><dd>is mapped to method's parameter <strong>valueLong</strong></dd>
   * </dl>.
   *
   * @param valueLong 	is used as where parameter <strong>${valueLong}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteLong(Long valueLong) {
    if (deleteLongPreparedStatement23==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_long=?";
      deleteLongPreparedStatement23 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteLongPreparedStatement23);
    _contentValues.addWhereArgs((valueLong==null?"":String.valueOf(valueLong)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_long=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteLongPreparedStatement23, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_long_type=${valueLongType}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueLongType}</dt><dd>is mapped to method's parameter <strong>valueLongType</strong></dd>
   * </dl>.
   *
   * @param valueLongType 	is used as where parameter <strong>${valueLongType}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteLongType(long valueLongType) {
    if (deleteLongTypePreparedStatement24==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_long_type=?";
      deleteLongTypePreparedStatement24 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteLongTypePreparedStatement24);
    _contentValues.addWhereArgs(String.valueOf(valueLongType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_long_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteLongTypePreparedStatement24, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_short=${valueShort}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueShort}</dt><dd>is mapped to method's parameter <strong>valueShort</strong></dd>
   * </dl>.
   *
   * @param valueShort 	is used as where parameter <strong>${valueShort}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteShort(Short valueShort) {
    if (deleteShortPreparedStatement25==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_short=?";
      deleteShortPreparedStatement25 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteShortPreparedStatement25);
    _contentValues.addWhereArgs((valueShort==null?"":String.valueOf(valueShort)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_short=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteShortPreparedStatement25, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_short_type=${valueShortType}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueShortType}</dt><dd>is mapped to method's parameter <strong>valueShortType</strong></dd>
   * </dl>.
   *
   * @param valueShortType 	is used as where parameter <strong>${valueShortType}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteShortType(short valueShortType) {
    if (deleteShortTypePreparedStatement26==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_short_type=?";
      deleteShortTypePreparedStatement26 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteShortTypePreparedStatement26);
    _contentValues.addWhereArgs(String.valueOf(valueShortType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_short_type=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteShortTypePreparedStatement26, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_string=${valueString}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueString}</dt><dd>is mapped to method's parameter <strong>valueString</strong></dd>
   * </dl>.
   *
   * @param valueString 	is used as where parameter <strong>${valueString}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteString(String valueString) {
    if (deleteStringPreparedStatement27==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_string=?";
      deleteStringPreparedStatement27 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteStringPreparedStatement27);
    _contentValues.addWhereArgs((valueString==null?"":valueString));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_string=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteStringPreparedStatement27, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_time=${valueTime}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueTime}</dt><dd>is mapped to method's parameter <strong>valueTime</strong></dd>
   * </dl>.
   *
   * @param valueTime 	is used as where parameter <strong>${valueTime}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteTime(Time valueTime) {
    if (deleteTimePreparedStatement28==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_time=?";
      deleteTimePreparedStatement28 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteTimePreparedStatement28);
    _contentValues.addWhereArgs((valueTime==null?"":SQLTimeUtils.write(valueTime)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_time=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteTimePreparedStatement28, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_time_zone=${valueTimeZone}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueTimeZone}</dt><dd>is mapped to method's parameter <strong>valueTimeZone</strong></dd>
   * </dl>.
   *
   * @param valueTimeZone 	is used as where parameter <strong>${valueTimeZone}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteTimeZone(TimeZone valueTimeZone) {
    if (deleteTimeZonePreparedStatement29==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_time_zone=?";
      deleteTimeZonePreparedStatement29 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteTimeZonePreparedStatement29);
    _contentValues.addWhereArgs((valueTimeZone==null?"":TimeZoneUtils.write(valueTimeZone)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_time_zone=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteTimeZonePreparedStatement29, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean WHERE value_url=${valueUrl}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueUrl}</dt><dd>is mapped to method's parameter <strong>valueUrl</strong></dd>
   * </dl>.
   *
   * @param valueUrl 	is used as where parameter <strong>${valueUrl}</strong>
   * @return number of deleted records
   */
  @Override
  public long deleteURL(URL valueUrl) {
    if (deleteURLPreparedStatement30==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean WHERE value_url=?";
      deleteURLPreparedStatement30 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deleteURLPreparedStatement30);
    _contentValues.addWhereArgs((valueUrl==null?"":UrlUtils.write(valueUrl)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean WHERE value_url=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deleteURLPreparedStatement30, _contentValues);
    return result;
  }

  /**
   * <p>SQL insert:</p>
   * <pre>INSERT INTO bean (value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string) VALUES (${bean.valueBoolType}, ${bean.valueBool}, ${bean.valueByteType}, ${bean.valueByte}, ${bean.valueShortType}, ${bean.valueShort}, ${bean.valueIntType}, ${bean.valueInt}, ${bean.valueString}, ${bean.valueCharType}, ${bean.valueChar}, ${bean.valueFloatType}, ${bean.valueFloat}, ${bean.valueBigInteger}, ${bean.valueBigDecimal}, ${bean.valueEnumType}, ${bean.valueLongType}, ${bean.valueLong}, ${bean.valueDoubleType}, ${bean.valueDouble}, ${bean.valueLocale}, ${bean.valueCalendar}, ${bean.valueDate}, ${bean.valueUrl}, ${bean.valueTime}, ${bean.valueCurrency}, ${bean.valueTimeZone}, ${bean.valueTimeList}, ${bean.valueStrinList}, ${bean.valueLongList}, ${bean.valueByteArray}, ${bean.valueLongTypeArray}, ${bean.valueLongArray}, ${bean.valueBeanArray}, ${bean.valueStringArray}, ${bean.valueCharList}, ${bean.valueCharTypeArray}, ${bean.valueCharArray}, ${bean.valueMapStringBean}, ${bean.valueLinkedMapStringBean}, ${bean.valueSetString})</pre>
   *
   * <p><code>bean.id</code> is automatically updated because it is the primary key</p>
   *
   * <p><strong>Inserted columns:</strong></p>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is mapped to <strong>${bean.valueBoolType}</strong></dd>
   * 	<dt>value_bool</dt><dd>is mapped to <strong>${bean.valueBool}</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is mapped to <strong>${bean.valueByteType}</strong></dd>
   * 	<dt>value_byte</dt><dd>is mapped to <strong>${bean.valueByte}</strong></dd>
   * 	<dt>value_short_type</dt><dd>is mapped to <strong>${bean.valueShortType}</strong></dd>
   * 	<dt>value_short</dt><dd>is mapped to <strong>${bean.valueShort}</strong></dd>
   * 	<dt>value_int_type</dt><dd>is mapped to <strong>${bean.valueIntType}</strong></dd>
   * 	<dt>value_int</dt><dd>is mapped to <strong>${bean.valueInt}</strong></dd>
   * 	<dt>value_string</dt><dd>is mapped to <strong>${bean.valueString}</strong></dd>
   * 	<dt>value_char_type</dt><dd>is mapped to <strong>${bean.valueCharType}</strong></dd>
   * 	<dt>value_char</dt><dd>is mapped to <strong>${bean.valueChar}</strong></dd>
   * 	<dt>value_float_type</dt><dd>is mapped to <strong>${bean.valueFloatType}</strong></dd>
   * 	<dt>value_float</dt><dd>is mapped to <strong>${bean.valueFloat}</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is mapped to <strong>${bean.valueBigInteger}</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is mapped to <strong>${bean.valueBigDecimal}</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is mapped to <strong>${bean.valueEnumType}</strong></dd>
   * 	<dt>value_long_type</dt><dd>is mapped to <strong>${bean.valueLongType}</strong></dd>
   * 	<dt>value_long</dt><dd>is mapped to <strong>${bean.valueLong}</strong></dd>
   * 	<dt>value_double_type</dt><dd>is mapped to <strong>${bean.valueDoubleType}</strong></dd>
   * 	<dt>value_double</dt><dd>is mapped to <strong>${bean.valueDouble}</strong></dd>
   * 	<dt>value_locale</dt><dd>is mapped to <strong>${bean.valueLocale}</strong></dd>
   * 	<dt>value_calendar</dt><dd>is mapped to <strong>${bean.valueCalendar}</strong></dd>
   * 	<dt>value_date</dt><dd>is mapped to <strong>${bean.valueDate}</strong></dd>
   * 	<dt>value_url</dt><dd>is mapped to <strong>${bean.valueUrl}</strong></dd>
   * 	<dt>value_time</dt><dd>is mapped to <strong>${bean.valueTime}</strong></dd>
   * 	<dt>value_currency</dt><dd>is mapped to <strong>${bean.valueCurrency}</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is mapped to <strong>${bean.valueTimeZone}</strong></dd>
   * 	<dt>value_time_list</dt><dd>is mapped to <strong>${bean.valueTimeList}</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is mapped to <strong>${bean.valueStrinList}</strong></dd>
   * 	<dt>value_long_list</dt><dd>is mapped to <strong>${bean.valueLongList}</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is mapped to <strong>${bean.valueByteArray}</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is mapped to <strong>${bean.valueLongTypeArray}</strong></dd>
   * 	<dt>value_long_array</dt><dd>is mapped to <strong>${bean.valueLongArray}</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is mapped to <strong>${bean.valueBeanArray}</strong></dd>
   * 	<dt>value_string_array</dt><dd>is mapped to <strong>${bean.valueStringArray}</strong></dd>
   * 	<dt>value_char_list</dt><dd>is mapped to <strong>${bean.valueCharList}</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is mapped to <strong>${bean.valueCharTypeArray}</strong></dd>
   * 	<dt>value_char_array</dt><dd>is mapped to <strong>${bean.valueCharArray}</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is mapped to <strong>${bean.valueMapStringBean}</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is mapped to <strong>${bean.valueLinkedMapStringBean}</strong></dd>
   * 	<dt>value_set_string</dt><dd>is mapped to <strong>${bean.valueSetString}</strong></dd>
   * </dl>
   *
   * @param bean
   * 	is mapped to parameter <strong>bean</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insert(Bean bean) {
    if (insertPreparedStatement31==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      insertPreparedStatement31 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertPreparedStatement31);
    _contentValues.put("value_bool_type", bean.valueBoolType);
    _contentValues.put("value_bool", bean.valueBool);
    _contentValues.put("value_byte_type", bean.valueByteType);
    _contentValues.put("value_byte", bean.valueByte);
    _contentValues.put("value_short_type", bean.valueShortType);
    _contentValues.put("value_short", bean.valueShort);
    _contentValues.put("value_int_type", bean.valueIntType);
    _contentValues.put("value_int", bean.valueInt);
    _contentValues.put("value_string", bean.valueString);
    _contentValues.put("value_char_type", bean.valueCharType);
    _contentValues.put("value_char", bean.valueChar);
    _contentValues.put("value_float_type", bean.valueFloatType);
    _contentValues.put("value_float", bean.valueFloat);
    _contentValues.put("value_big_integer", bean.valueBigInteger);
    _contentValues.put("value_big_decimal", bean.valueBigDecimal);
    _contentValues.put("value_enum_type", EnumUtils.write(bean.valueEnumType));
    _contentValues.put("value_long_type", bean.valueLongType);
    _contentValues.put("value_long", bean.valueLong);
    _contentValues.put("value_double_type", bean.valueDoubleType);
    _contentValues.put("value_double", bean.valueDouble);
    _contentValues.put("value_locale", LocaleUtils.write(bean.valueLocale));
    _contentValues.put("value_calendar", CalendarUtils.write(bean.valueCalendar));
    _contentValues.put("value_date", DateUtils.write(bean.valueDate));
    _contentValues.put("value_url", UrlUtils.write(bean.valueUrl));
    _contentValues.put("value_time", SQLTimeUtils.write(bean.valueTime));
    _contentValues.put("value_currency", CurrencyUtils.write(bean.valueCurrency));
    _contentValues.put("value_time_zone", TimeZoneUtils.write(bean.valueTimeZone));
    _contentValues.put("value_time_list", BeanTable.serializeValueTimeList(bean.valueTimeList));
    _contentValues.put("value_strin_list", BeanTable.serializeValueStrinList(bean.valueStrinList));
    _contentValues.put("value_long_list", BeanTable.serializeValueLongList(bean.valueLongList));
    _contentValues.put("value_byte_array", bean.valueByteArray);
    _contentValues.put("value_long_type_array", BeanTable.serializeValueLongTypeArray(bean.valueLongTypeArray));
    _contentValues.put("value_long_array", BeanTable.serializeValueLongArray(bean.valueLongArray));
    _contentValues.put("value_bean_array", BeanTable.serializeValueBeanArray(bean.valueBeanArray));
    _contentValues.put("value_string_array", BeanTable.serializeValueStringArray(bean.valueStringArray));
    _contentValues.put("value_char_list", BeanTable.serializeValueCharList(bean.valueCharList));
    _contentValues.put("value_char_type_array", BeanTable.serializeValueCharTypeArray(bean.valueCharTypeArray));
    _contentValues.put("value_char_array", BeanTable.serializeValueCharArray(bean.valueCharArray));
    _contentValues.put("value_map_string_bean", BeanTable.serializeValueMapStringBean(bean.valueMapStringBean));
    _contentValues.put("value_linked_map_string_bean", BeanTable.serializeValueLinkedMapStringBean(bean.valueLinkedMapStringBean));
    _contentValues.put("value_set_string", BeanTable.serializeValueSetString(bean.valueSetString));

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertPreparedStatement31, _contentValues);
    bean.id=result;

    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_big_decimal) VALUES (${valueBigDecimal})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueBigDecimal</dt><dd>is binded to query's parameter <strong>${valueBigDecimal}</strong> and method's parameter <strong>valueBigDecimal</strong></dd>
   * </dl>.
   *
   * @param valueBigDecimal 	is binded to column value <strong>value_big_decimal</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insert(BigDecimal valueBigDecimal) {
    if (insertPreparedStatement32==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_big_decimal) VALUES (?)";
      insertPreparedStatement32 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertPreparedStatement32);

    _contentValues.put("value_big_decimal", valueBigDecimal);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertPreparedStatement32, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_big_integer) VALUES (${valueBigInteger})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueBigInteger</dt><dd>is binded to query's parameter <strong>${valueBigInteger}</strong> and method's parameter <strong>valueBigInteger</strong></dd>
   * </dl>.
   *
   * @param valueBigInteger 	is binded to column value <strong>value_big_integer</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insert(BigInteger valueBigInteger) {
    if (insertPreparedStatement33==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_big_integer) VALUES (?)";
      insertPreparedStatement33 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertPreparedStatement33);

    _contentValues.put("value_big_integer", valueBigInteger);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertPreparedStatement33, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_bool_type) VALUES (${valueBoolType})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueBoolType</dt><dd>is binded to query's parameter <strong>${valueBoolType}</strong> and method's parameter <strong>valueBoolType</strong></dd>
   * </dl>.
   *
   * @param valueBoolType 	is binded to column value <strong>value_bool_type</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insert(boolean valueBoolType) {
    if (insertPreparedStatement34==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_bool_type) VALUES (?)";
      insertPreparedStatement34 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertPreparedStatement34);

    _contentValues.put("value_bool_type", valueBoolType);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertPreparedStatement34, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_bool) VALUES (${valueBool})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueBool</dt><dd>is binded to query's parameter <strong>${valueBool}</strong> and method's parameter <strong>valueBool</strong></dd>
   * </dl>.
   *
   * @param valueBool 	is binded to column value <strong>value_bool</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insert(Boolean valueBool) {
    if (insertPreparedStatement35==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_bool) VALUES (?)";
      insertPreparedStatement35 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertPreparedStatement35);

    _contentValues.put("value_bool", valueBool);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertPreparedStatement35, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_bean_array) VALUES (${valueBeanArray})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueBeanArray</dt><dd>is binded to query's parameter <strong>${valueBeanArray}</strong> and method's parameter <strong>valueBeanArray</strong></dd>
   * </dl>.
   *
   * @param valueBeanArray 	is binded to column value <strong>value_bean_array</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertArrayBeanType(Bean[] valueBeanArray) {
    if (insertArrayBeanTypePreparedStatement36==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_bean_array) VALUES (?)";
      insertArrayBeanTypePreparedStatement36 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertArrayBeanTypePreparedStatement36);

    _contentValues.put("value_bean_array", serializer1(valueBeanArray));

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertArrayBeanTypePreparedStatement36, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_long_array) VALUES (${valueLongArray})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueLongArray</dt><dd>is binded to query's parameter <strong>${valueLongArray}</strong> and method's parameter <strong>valueLongArray</strong></dd>
   * </dl>.
   *
   * @param valueLongArray 	is binded to column value <strong>value_long_array</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertArrayLong(Long[] valueLongArray) {
    if (insertArrayLongPreparedStatement37==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_long_array) VALUES (?)";
      insertArrayLongPreparedStatement37 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertArrayLongPreparedStatement37);

    _contentValues.put("value_long_array", serializer2(valueLongArray));

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertArrayLongPreparedStatement37, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_long_type_array) VALUES (${valueLongTypeArray})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueLongTypeArray</dt><dd>is binded to query's parameter <strong>${valueLongTypeArray}</strong> and method's parameter <strong>valueLongTypeArray</strong></dd>
   * </dl>.
   *
   * @param valueLongTypeArray 	is binded to column value <strong>value_long_type_array</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertArrayLongType(long[] valueLongTypeArray) {
    if (insertArrayLongTypePreparedStatement38==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_long_type_array) VALUES (?)";
      insertArrayLongTypePreparedStatement38 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertArrayLongTypePreparedStatement38);

    _contentValues.put("value_long_type_array", serializer3(valueLongTypeArray));

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertArrayLongTypePreparedStatement38, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_byte) VALUES (${valueByte})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueByte</dt><dd>is binded to query's parameter <strong>${valueByte}</strong> and method's parameter <strong>valueByte</strong></dd>
   * </dl>.
   *
   * @param valueByte 	is binded to column value <strong>value_byte</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertByte(Byte valueByte) {
    if (insertBytePreparedStatement39==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_byte) VALUES (?)";
      insertBytePreparedStatement39 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertBytePreparedStatement39);

    _contentValues.put("value_byte", valueByte);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertBytePreparedStatement39, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_byte_type) VALUES (${valueByteType})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueByteType</dt><dd>is binded to query's parameter <strong>${valueByteType}</strong> and method's parameter <strong>valueByteType</strong></dd>
   * </dl>.
   *
   * @param valueByteType 	is binded to column value <strong>value_byte_type</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertByteType(byte valueByteType) {
    if (insertByteTypePreparedStatement40==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_byte_type) VALUES (?)";
      insertByteTypePreparedStatement40 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertByteTypePreparedStatement40);

    _contentValues.put("value_byte_type", valueByteType);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertByteTypePreparedStatement40, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_calendar) VALUES (${valueCalendar})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueCalendar</dt><dd>is binded to query's parameter <strong>${valueCalendar}</strong> and method's parameter <strong>valueCalendar</strong></dd>
   * </dl>.
   *
   * @param valueCalendar 	is binded to column value <strong>value_calendar</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertCalendar(Calendar valueCalendar) {
    if (insertCalendarPreparedStatement41==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_calendar) VALUES (?)";
      insertCalendarPreparedStatement41 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertCalendarPreparedStatement41);

    _contentValues.put("value_calendar", CalendarUtils.write(valueCalendar));

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertCalendarPreparedStatement41, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_char) VALUES (${valueChar})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueChar</dt><dd>is binded to query's parameter <strong>${valueChar}</strong> and method's parameter <strong>valueChar</strong></dd>
   * </dl>.
   *
   * @param valueChar 	is binded to column value <strong>value_char</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertChar(Character valueChar) {
    if (insertCharPreparedStatement42==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_char) VALUES (?)";
      insertCharPreparedStatement42 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertCharPreparedStatement42);

    _contentValues.put("value_char", valueChar);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertCharPreparedStatement42, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_char_type) VALUES (${valueCharType})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueCharType</dt><dd>is binded to query's parameter <strong>${valueCharType}</strong> and method's parameter <strong>valueCharType</strong></dd>
   * </dl>.
   *
   * @param valueCharType 	is binded to column value <strong>value_char_type</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertCharType(char valueCharType) {
    if (insertCharTypePreparedStatement43==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_char_type) VALUES (?)";
      insertCharTypePreparedStatement43 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertCharTypePreparedStatement43);

    _contentValues.put("value_char_type", valueCharType);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertCharTypePreparedStatement43, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_currency) VALUES (${valueCurrency})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueCurrency</dt><dd>is binded to query's parameter <strong>${valueCurrency}</strong> and method's parameter <strong>valueCurrency</strong></dd>
   * </dl>.
   *
   * @param valueCurrency 	is binded to column value <strong>value_currency</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertCurrency(Currency valueCurrency) {
    if (insertCurrencyPreparedStatement44==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_currency) VALUES (?)";
      insertCurrencyPreparedStatement44 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertCurrencyPreparedStatement44);

    _contentValues.put("value_currency", CurrencyUtils.write(valueCurrency));

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertCurrencyPreparedStatement44, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_date) VALUES (${valueDate})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueDate</dt><dd>is binded to query's parameter <strong>${valueDate}</strong> and method's parameter <strong>valueDate</strong></dd>
   * </dl>.
   *
   * @param valueDate 	is binded to column value <strong>value_date</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertDate(Date valueDate) {
    if (insertDatePreparedStatement45==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_date) VALUES (?)";
      insertDatePreparedStatement45 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertDatePreparedStatement45);

    _contentValues.put("value_date", DateUtils.write(valueDate));

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertDatePreparedStatement45, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_double) VALUES (${valueDouble})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueDouble</dt><dd>is binded to query's parameter <strong>${valueDouble}</strong> and method's parameter <strong>valueDouble</strong></dd>
   * </dl>.
   *
   * @param valueDouble 	is binded to column value <strong>value_double</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertDouble(Double valueDouble) {
    if (insertDoublePreparedStatement46==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_double) VALUES (?)";
      insertDoublePreparedStatement46 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertDoublePreparedStatement46);

    _contentValues.put("value_double", valueDouble);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertDoublePreparedStatement46, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_double_type) VALUES (${valueDoubleType})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueDoubleType</dt><dd>is binded to query's parameter <strong>${valueDoubleType}</strong> and method's parameter <strong>valueDoubleType</strong></dd>
   * </dl>.
   *
   * @param valueDoubleType 	is binded to column value <strong>value_double_type</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertDoubleType(double valueDoubleType) {
    if (insertDoubleTypePreparedStatement47==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_double_type) VALUES (?)";
      insertDoubleTypePreparedStatement47 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertDoubleTypePreparedStatement47);

    _contentValues.put("value_double_type", valueDoubleType);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertDoubleTypePreparedStatement47, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_enum_type) VALUES (${valueEnumType})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueEnumType</dt><dd>is binded to query's parameter <strong>${valueEnumType}</strong> and method's parameter <strong>valueEnumType</strong></dd>
   * </dl>.
   *
   * @param valueEnumType 	is binded to column value <strong>value_enum_type</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertEnumType(EnumType valueEnumType) {
    if (insertEnumTypePreparedStatement48==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_enum_type) VALUES (?)";
      insertEnumTypePreparedStatement48 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertEnumTypePreparedStatement48);

    _contentValues.put("value_enum_type", EnumUtils.write(valueEnumType));

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertEnumTypePreparedStatement48, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_float) VALUES (${valueFloat})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueFloat</dt><dd>is binded to query's parameter <strong>${valueFloat}</strong> and method's parameter <strong>valueFloat</strong></dd>
   * </dl>.
   *
   * @param valueFloat 	is binded to column value <strong>value_float</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertFloat(Float valueFloat) {
    if (insertFloatPreparedStatement49==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_float) VALUES (?)";
      insertFloatPreparedStatement49 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertFloatPreparedStatement49);

    _contentValues.put("value_float", valueFloat);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertFloatPreparedStatement49, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_float_type) VALUES (${valueFloatType})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueFloatType</dt><dd>is binded to query's parameter <strong>${valueFloatType}</strong> and method's parameter <strong>valueFloatType</strong></dd>
   * </dl>.
   *
   * @param valueFloatType 	is binded to column value <strong>value_float_type</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertFloatType(float valueFloatType) {
    if (insertFloatTypePreparedStatement50==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_float_type) VALUES (?)";
      insertFloatTypePreparedStatement50 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertFloatTypePreparedStatement50);

    _contentValues.put("value_float_type", valueFloatType);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertFloatTypePreparedStatement50, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_int) VALUES (${valueInt})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueInt</dt><dd>is binded to query's parameter <strong>${valueInt}</strong> and method's parameter <strong>valueInt</strong></dd>
   * </dl>.
   *
   * @param valueInt 	is binded to column value <strong>value_int</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertInt(Integer valueInt) {
    if (insertIntPreparedStatement51==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_int) VALUES (?)";
      insertIntPreparedStatement51 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertIntPreparedStatement51);

    _contentValues.put("value_int", valueInt);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertIntPreparedStatement51, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_int_type) VALUES (${valueIntType})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueIntType</dt><dd>is binded to query's parameter <strong>${valueIntType}</strong> and method's parameter <strong>valueIntType</strong></dd>
   * </dl>.
   *
   * @param valueIntType 	is binded to column value <strong>value_int_type</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertIntType(int valueIntType) {
    if (insertIntTypePreparedStatement52==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_int_type) VALUES (?)";
      insertIntTypePreparedStatement52 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertIntTypePreparedStatement52);

    _contentValues.put("value_int_type", valueIntType);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertIntTypePreparedStatement52, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_long_list) VALUES (${valueLongList})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueLongList</dt><dd>is binded to query's parameter <strong>${valueLongList}</strong> and method's parameter <strong>valueLongList</strong></dd>
   * </dl>.
   *
   * @param valueLongList 	is binded to column value <strong>value_long_list</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertListLong(LinkedList<Long> valueLongList) {
    if (insertListLongPreparedStatement53==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_long_list) VALUES (?)";
      insertListLongPreparedStatement53 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertListLongPreparedStatement53);

    _contentValues.put("value_long_list", serializer4(valueLongList));

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertListLongPreparedStatement53, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_locale) VALUES (${valueLocale})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueLocale</dt><dd>is binded to query's parameter <strong>${valueLocale}</strong> and method's parameter <strong>valueLocale</strong></dd>
   * </dl>.
   *
   * @param valueLocale 	is binded to column value <strong>value_locale</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertLocale(Locale valueLocale) {
    if (insertLocalePreparedStatement54==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_locale) VALUES (?)";
      insertLocalePreparedStatement54 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertLocalePreparedStatement54);

    _contentValues.put("value_locale", LocaleUtils.write(valueLocale));

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertLocalePreparedStatement54, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_long) VALUES (${valueLong})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueLong</dt><dd>is binded to query's parameter <strong>${valueLong}</strong> and method's parameter <strong>valueLong</strong></dd>
   * </dl>.
   *
   * @param valueLong 	is binded to column value <strong>value_long</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertLong(Long valueLong) {
    if (insertLongPreparedStatement55==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_long) VALUES (?)";
      insertLongPreparedStatement55 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertLongPreparedStatement55);

    _contentValues.put("value_long", valueLong);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertLongPreparedStatement55, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_long_type) VALUES (${valueLongType})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueLongType</dt><dd>is binded to query's parameter <strong>${valueLongType}</strong> and method's parameter <strong>valueLongType</strong></dd>
   * </dl>.
   *
   * @param valueLongType 	is binded to column value <strong>value_long_type</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertLongType(long valueLongType) {
    if (insertLongTypePreparedStatement56==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_long_type) VALUES (?)";
      insertLongTypePreparedStatement56 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertLongTypePreparedStatement56);

    _contentValues.put("value_long_type", valueLongType);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertLongTypePreparedStatement56, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_short) VALUES (${valueShort})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueShort</dt><dd>is binded to query's parameter <strong>${valueShort}</strong> and method's parameter <strong>valueShort</strong></dd>
   * </dl>.
   *
   * @param valueShort 	is binded to column value <strong>value_short</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertShort(Short valueShort) {
    if (insertShortPreparedStatement57==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_short) VALUES (?)";
      insertShortPreparedStatement57 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertShortPreparedStatement57);

    _contentValues.put("value_short", valueShort);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertShortPreparedStatement57, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_short_type) VALUES (${valueShortType})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueShortType</dt><dd>is binded to query's parameter <strong>${valueShortType}</strong> and method's parameter <strong>valueShortType</strong></dd>
   * </dl>.
   *
   * @param valueShortType 	is binded to column value <strong>value_short_type</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertShortType(short valueShortType) {
    if (insertShortTypePreparedStatement58==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_short_type) VALUES (?)";
      insertShortTypePreparedStatement58 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertShortTypePreparedStatement58);

    _contentValues.put("value_short_type", valueShortType);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertShortTypePreparedStatement58, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_string) VALUES (${valueString})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueString</dt><dd>is binded to query's parameter <strong>${valueString}</strong> and method's parameter <strong>valueString</strong></dd>
   * </dl>.
   *
   * @param valueString 	is binded to column value <strong>value_string</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertString(String valueString) {
    if (insertStringPreparedStatement59==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_string) VALUES (?)";
      insertStringPreparedStatement59 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertStringPreparedStatement59);

    _contentValues.put("value_string", valueString);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertStringPreparedStatement59, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_time) VALUES (${valueTime})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueTime</dt><dd>is binded to query's parameter <strong>${valueTime}</strong> and method's parameter <strong>valueTime</strong></dd>
   * </dl>.
   *
   * @param valueTime 	is binded to column value <strong>value_time</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertTime(Time valueTime) {
    if (insertTimePreparedStatement60==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_time) VALUES (?)";
      insertTimePreparedStatement60 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertTimePreparedStatement60);

    _contentValues.put("value_time", SQLTimeUtils.write(valueTime));

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertTimePreparedStatement60, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_time_zone) VALUES (${valueTimeZone})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueTimeZone</dt><dd>is binded to query's parameter <strong>${valueTimeZone}</strong> and method's parameter <strong>valueTimeZone</strong></dd>
   * </dl>.
   *
   * @param valueTimeZone 	is binded to column value <strong>value_time_zone</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertTimeZone(TimeZone valueTimeZone) {
    if (insertTimeZonePreparedStatement61==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_time_zone) VALUES (?)";
      insertTimeZonePreparedStatement61 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertTimeZonePreparedStatement61);

    _contentValues.put("value_time_zone", TimeZoneUtils.write(valueTimeZone));

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertTimeZonePreparedStatement61, _contentValues);
    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean (value_url) VALUES (${valueUrl})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>valueUrl</dt><dd>is binded to query's parameter <strong>${valueUrl}</strong> and method's parameter <strong>valueUrl</strong></dd>
   * </dl>.
   *
   * @param valueUrl 	is binded to column value <strong>value_url</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insertURL(URL valueUrl) {
    if (insertURLPreparedStatement62==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean (value_url) VALUES (?)";
      insertURLPreparedStatement62 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertURLPreparedStatement62);

    _contentValues.put("value_url", UrlUtils.write(valueUrl));

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertURLPreparedStatement62, _contentValues);
    return result;
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE id = ${id}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${id}</dt><dd>is binded to method's parameter <strong>id</strong></dd>
   * </dl>.
   *
   * @param id 	is binded to <code>${id}</code>
   * @return collection of bean or empty collection.
   */
  @Override
  public List<Bean> selectList(long id) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_LIST_SQL1;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(id));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      ArrayList<Bean> resultList=new ArrayList<Bean>(_cursor.getCount());
      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        do
         {
          resultBean=new Bean();

          if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
          if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
          if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
          if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
          if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
          if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
          if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
          if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
          if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
          if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
          if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
          if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
          if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
          if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
          if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
          if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
          if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
          if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
          if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
          if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
          if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
          if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
          if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
          if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
          if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
          if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
          if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
          if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
          if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
          if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
          if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
          if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
          if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
          if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
          if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
          if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
          if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
          if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
          if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
          if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
          if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
          resultBean.id=_cursor.getLong(index41);

          resultList.add(resultBean);
        } while (_cursor.moveToNext());
      }

      return resultList;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>.
   *
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOne() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SQL2;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_big_decimal=${valueBigDecimal}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueBigDecimal}</dt><dd>is binded to method's parameter <strong>valueBigDecimal</strong></dd>
   * </dl>.
   *
   * @param valueBigDecimal 	is binded to <code>${valueBigDecimal}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOne(BigDecimal valueBigDecimal) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SQL3;
    // add where arguments
    _contentValues.addWhereArgs((valueBigDecimal==null?"":valueBigDecimal.toPlainString()));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_big_decimal=${valueBigDecimal}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueBigDecimal}</dt><dd>is binded to method's parameter <strong>valueBigDecimal</strong></dd>
   * </dl>.
   *
   * @param valueBigDecimal 	is binded to <code>${valueBigDecimal}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOne(BigInteger valueBigDecimal) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SQL4;
    // add where arguments
    _contentValues.addWhereArgs((valueBigDecimal==null?"":valueBigDecimal.toString()));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_bool_type=${valueBoolType}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueBoolType}</dt><dd>is binded to method's parameter <strong>valueBoolType</strong></dd>
   * </dl>.
   *
   * @param valueBoolType 	is binded to <code>${valueBoolType}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOne(boolean valueBoolType) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SQL5;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueBoolType));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_bool=${valueBool}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueBool}</dt><dd>is binded to method's parameter <strong>valueBool</strong></dd>
   * </dl>.
   *
   * @param valueBool 	is binded to <code>${valueBool}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOne(Boolean valueBool) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SQL6;
    // add where arguments
    _contentValues.addWhereArgs((valueBool==null?"":String.valueOf(valueBool)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE id = ${id}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${id}</dt><dd>is binded to method's parameter <strong>id</strong></dd>
   * </dl>.
   *
   * @param id 	is binded to <code>${id}</code>
   * @param listener 	is the Bean listener
   */
  @Override
  public void selectOne(int id, OnReadBeanListener<Bean> listener) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SQL7;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(id));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      Bean resultBean=new Bean();
      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        int rowCount=_cursor.getCount();
        do
         {
          // reset mapping
          resultBean.valueBoolType=false;
          resultBean.valueBool=null;
          resultBean.valueByteType=0;
          resultBean.valueByte=null;
          resultBean.valueShortType=0;
          resultBean.valueShort=null;
          resultBean.valueIntType=0;
          resultBean.valueInt=null;
          resultBean.valueString=null;
          resultBean.valueCharType=0;
          resultBean.valueChar=null;
          resultBean.valueFloatType=0f;
          resultBean.valueFloat=null;
          resultBean.valueBigInteger=null;
          resultBean.valueBigDecimal=null;
          resultBean.valueEnumType=null;
          resultBean.valueLongType=0L;
          resultBean.valueLong=null;
          resultBean.valueDoubleType=0;
          resultBean.valueDouble=null;
          resultBean.valueLocale=null;
          resultBean.valueCalendar=null;
          resultBean.valueDate=null;
          resultBean.valueUrl=null;
          resultBean.valueTime=null;
          resultBean.valueCurrency=null;
          resultBean.valueTimeZone=null;
          resultBean.valueTimeList=null;
          resultBean.valueStrinList=null;
          resultBean.valueLongList=null;
          resultBean.valueByteArray=null;
          resultBean.valueLongTypeArray=null;
          resultBean.valueLongArray=null;
          resultBean.valueBeanArray=null;
          resultBean.valueStringArray=null;
          resultBean.valueCharList=null;
          resultBean.valueCharTypeArray=null;
          resultBean.valueCharArray=null;
          resultBean.valueMapStringBean=null;
          resultBean.valueLinkedMapStringBean=null;
          resultBean.valueSetString=null;
          // id does not need reset

          // generate mapping
          if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
          if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
          if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
          if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
          if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
          if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
          if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
          if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
          if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
          if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
          if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
          if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
          if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
          if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
          if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
          if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
          if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
          if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
          if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
          if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
          if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
          if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
          if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
          if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
          if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
          if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
          if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
          if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
          if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
          if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
          if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
          if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
          if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
          if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
          if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
          if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
          if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
          if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
          if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
          if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
          if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
          resultBean.id=_cursor.getLong(index41);

          listener.onRead(resultBean, _cursor.getPosition(), rowCount);
        } while (_cursor.moveToNext());
      }
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE id = ${id}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${id}</dt><dd>is binded to method's parameter <strong>id</strong></dd>
   * </dl>.
   *
   * @param id 	is binded to <code>${id}</code>
   * @param listener 	is the cursor listener
   */
  @Override
  public void selectOne(long id, OnReadCursorListener listener) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SQL8;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(id));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      if (_cursor.moveToFirst()) {

        do
         {
          listener.onRead(_cursor);
        } while (_cursor.moveToNext());
      }
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_bean_array=${valueBeanArray}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueBeanArray}</dt><dd>is binded to method's parameter <strong>valueBeanArray</strong></dd>
   * </dl>.
   *
   * @param valueBeanArray 	is binded to <code>${valueBeanArray}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneArrayBeanType(Bean[] valueBeanArray) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_ARRAY_BEAN_TYPE_SQL9;
    // add where arguments
    _contentValues.addWhereArgs((valueBeanArray==null?"":new String(serializer1(valueBeanArray),StandardCharsets.UTF_8)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_long_array=${valueLongArray}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueLongArray}</dt><dd>is binded to method's parameter <strong>valueLongArray</strong></dd>
   * </dl>.
   *
   * @param valueLongArray 	is binded to <code>${valueLongArray}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneArrayLong(Long[] valueLongArray) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_ARRAY_LONG_SQL10;
    // add where arguments
    _contentValues.addWhereArgs((valueLongArray==null?"":new String(serializer2(valueLongArray),StandardCharsets.UTF_8)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_long_type_array=${valueLongTypeArray}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueLongTypeArray}</dt><dd>is binded to method's parameter <strong>valueLongTypeArray</strong></dd>
   * </dl>.
   *
   * @param valueLongTypeArray 	is binded to <code>${valueLongTypeArray}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneArrayLongType(long[] valueLongTypeArray) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_ARRAY_LONG_TYPE_SQL11;
    // add where arguments
    _contentValues.addWhereArgs((valueLongTypeArray==null?"":new String(serializer3(valueLongTypeArray),StandardCharsets.UTF_8)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_byte=${valueByte}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueByte}</dt><dd>is binded to method's parameter <strong>valueByte</strong></dd>
   * </dl>.
   *
   * @param valueByte 	is binded to <code>${valueByte}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneByte(Byte valueByte) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_BYTE_SQL12;
    // add where arguments
    _contentValues.addWhereArgs((valueByte==null?"":String.valueOf(valueByte)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_byte_type=${valueByteType}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueByteType}</dt><dd>is binded to method's parameter <strong>valueByteType</strong></dd>
   * </dl>.
   *
   * @param valueByteType 	is binded to <code>${valueByteType}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneByteType(boolean valueByteType) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_BYTE_TYPE_SQL13;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueByteType));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_calendar=${valueCalendar}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueCalendar}</dt><dd>is binded to method's parameter <strong>valueCalendar</strong></dd>
   * </dl>.
   *
   * @param valueCalendar 	is binded to <code>${valueCalendar}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneCalendar(Calendar valueCalendar) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_CALENDAR_SQL14;
    // add where arguments
    _contentValues.addWhereArgs((valueCalendar==null?"":CalendarUtils.write(valueCalendar)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_char_type=${valueChar}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueChar}</dt><dd>is binded to method's parameter <strong>valueChar</strong></dd>
   * </dl>.
   *
   * @param valueChar 	is binded to <code>${valueChar}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneChar(Character valueChar) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_CHAR_SQL15;
    // add where arguments
    _contentValues.addWhereArgs((valueChar==null?"":String.valueOf(valueChar)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_char_type=${valueCharType}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueCharType}</dt><dd>is binded to method's parameter <strong>valueCharType</strong></dd>
   * </dl>.
   *
   * @param valueCharType 	is binded to <code>${valueCharType}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneCharType(char valueCharType) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_CHAR_TYPE_SQL16;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueCharType));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_currency=${valueCurrency}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueCurrency}</dt><dd>is binded to method's parameter <strong>valueCurrency</strong></dd>
   * </dl>.
   *
   * @param valueCurrency 	is binded to <code>${valueCurrency}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneCurrencye(Currency valueCurrency) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_CURRENCYE_SQL17;
    // add where arguments
    _contentValues.addWhereArgs((valueCurrency==null?"":CurrencyUtils.write(valueCurrency)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_date=${valueDate}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueDate}</dt><dd>is binded to method's parameter <strong>valueDate</strong></dd>
   * </dl>.
   *
   * @param valueDate 	is binded to <code>${valueDate}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneDate(Date valueDate) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_DATE_SQL18;
    // add where arguments
    _contentValues.addWhereArgs((valueDate==null?"":DateUtils.write(valueDate)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_double=${valueDouble}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueDouble}</dt><dd>is binded to method's parameter <strong>valueDouble</strong></dd>
   * </dl>.
   *
   * @param valueDouble 	is binded to <code>${valueDouble}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneDouble(Double valueDouble) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_DOUBLE_SQL19;
    // add where arguments
    _contentValues.addWhereArgs((valueDouble==null?"":String.valueOf(valueDouble)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_double_type=${valueDoubleType}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueDoubleType}</dt><dd>is binded to method's parameter <strong>valueDoubleType</strong></dd>
   * </dl>.
   *
   * @param valueDoubleType 	is binded to <code>${valueDoubleType}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneDoubleType(double valueDoubleType) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_DOUBLE_TYPE_SQL20;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueDoubleType));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_enum_type=${valueEnumType}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueEnumType}</dt><dd>is binded to method's parameter <strong>valueEnumType</strong></dd>
   * </dl>.
   *
   * @param valueEnumType 	is binded to <code>${valueEnumType}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneEnumType(EnumType valueEnumType) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_ENUM_TYPE_SQL21;
    // add where arguments
    _contentValues.addWhereArgs((valueEnumType==null?"":EnumUtils.write(valueEnumType)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_float=${valueFloat}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueFloat}</dt><dd>is binded to method's parameter <strong>valueFloat</strong></dd>
   * </dl>.
   *
   * @param valueFloat 	is binded to <code>${valueFloat}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneFloat(Float valueFloat) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_FLOAT_SQL22;
    // add where arguments
    _contentValues.addWhereArgs((valueFloat==null?"":String.valueOf(valueFloat)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_float_type=${valueFloatType}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueFloatType}</dt><dd>is binded to method's parameter <strong>valueFloatType</strong></dd>
   * </dl>.
   *
   * @param valueFloatType 	is binded to <code>${valueFloatType}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneFloatType(float valueFloatType) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_FLOAT_TYPE_SQL23;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueFloatType));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_int=${valueInt}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueInt}</dt><dd>is binded to method's parameter <strong>valueInt</strong></dd>
   * </dl>.
   *
   * @param valueInt 	is binded to <code>${valueInt}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneInt(Integer valueInt) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_INT_SQL24;
    // add where arguments
    _contentValues.addWhereArgs((valueInt==null?"":String.valueOf(valueInt)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_int_type=${valueIntType}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueIntType}</dt><dd>is binded to method's parameter <strong>valueIntType</strong></dd>
   * </dl>.
   *
   * @param valueIntType 	is binded to <code>${valueIntType}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneIntType(int valueIntType) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_INT_TYPE_SQL25;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueIntType));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_long_list=${valueLongList}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueLongList}</dt><dd>is binded to method's parameter <strong>valueLongList</strong></dd>
   * </dl>.
   *
   * @param valueLongList 	is binded to <code>${valueLongList}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneListLong(LinkedList<Long> valueLongList) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_LIST_LONG_SQL26;
    // add where arguments
    _contentValues.addWhereArgs((valueLongList==null?"":new String(serializer4(valueLongList),StandardCharsets.UTF_8)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_locale=${valueLocale}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueLocale}</dt><dd>is binded to method's parameter <strong>valueLocale</strong></dd>
   * </dl>.
   *
   * @param valueLocale 	is binded to <code>${valueLocale}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneLocale(Calendar valueLocale) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_LOCALE_SQL27;
    // add where arguments
    _contentValues.addWhereArgs((valueLocale==null?"":CalendarUtils.write(valueLocale)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_long=${valueLong}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueLong}</dt><dd>is binded to method's parameter <strong>valueLong</strong></dd>
   * </dl>.
   *
   * @param valueLong 	is binded to <code>${valueLong}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneLong(Long valueLong) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_LONG_SQL28;
    // add where arguments
    _contentValues.addWhereArgs((valueLong==null?"":String.valueOf(valueLong)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_long_type=${valueLongType}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueLongType}</dt><dd>is binded to method's parameter <strong>valueLongType</strong></dd>
   * </dl>.
   *
   * @param valueLongType 	is binded to <code>${valueLongType}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneLongType(long valueLongType) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_LONG_TYPE_SQL29;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueLongType));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_short=${valueShort}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueShort}</dt><dd>is binded to method's parameter <strong>valueShort</strong></dd>
   * </dl>.
   *
   * @param valueShort 	is binded to <code>${valueShort}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneShort(Short valueShort) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SHORT_SQL30;
    // add where arguments
    _contentValues.addWhereArgs((valueShort==null?"":String.valueOf(valueShort)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_short_type=${valueShortType}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueShortType}</dt><dd>is binded to method's parameter <strong>valueShortType</strong></dd>
   * </dl>.
   *
   * @param valueShortType 	is binded to <code>${valueShortType}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneShortType(short valueShortType) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_SHORT_TYPE_SQL31;
    // add where arguments
    _contentValues.addWhereArgs(String.valueOf(valueShortType));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_string=${valueString}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueString}</dt><dd>is binded to method's parameter <strong>valueString</strong></dd>
   * </dl>.
   *
   * @param valueString 	is binded to <code>${valueString}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneString(String valueString) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_STRING_SQL32;
    // add where arguments
    _contentValues.addWhereArgs((valueString==null?"":valueString));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_time=${valueTime}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueTime}</dt><dd>is binded to method's parameter <strong>valueTime</strong></dd>
   * </dl>.
   *
   * @param valueTime 	is binded to <code>${valueTime}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneTime(Time valueTime) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_TIME_SQL33;
    // add where arguments
    _contentValues.addWhereArgs((valueTime==null?"":SQLTimeUtils.write(valueTime)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_time_zone=${valueTimeZone}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueTimeZone}</dt><dd>is binded to method's parameter <strong>valueTimeZone</strong></dd>
   * </dl>.
   *
   * @param valueTimeZone 	is binded to <code>${valueTimeZone}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneTimeZone(TimeZone valueTimeZone) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_TIME_ZONE_SQL34;
    // add where arguments
    _contentValues.addWhereArgs((valueTimeZone==null?"":TimeZoneUtils.write(valueTimeZone)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type, value_bool, value_byte_type, value_byte, value_short_type, value_short, value_int_type, value_int, value_string, value_char_type, value_char, value_float_type, value_float, value_big_integer, value_big_decimal, value_enum_type, value_long_type, value_long, value_double_type, value_double, value_locale, value_calendar, value_date, value_url, value_time, value_currency, value_time_zone, value_time_list, value_strin_list, value_long_list, value_byte_array, value_long_type_array, value_long_array, value_bean_array, value_string_array, value_char_list, value_char_type_array, value_char_array, value_map_string_bean, value_linked_map_string_bean, value_set_string, id FROM bean WHERE value_url=${valueUrl}</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is associated to bean's property <strong>valueBigInteger</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is associated to bean's property <strong>valueBigDecimal</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is associated to bean's property <strong>valueEnumType</strong></dd>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * 	<dt>value_locale</dt><dd>is associated to bean's property <strong>valueLocale</strong></dd>
   * 	<dt>value_calendar</dt><dd>is associated to bean's property <strong>valueCalendar</strong></dd>
   * 	<dt>value_date</dt><dd>is associated to bean's property <strong>valueDate</strong></dd>
   * 	<dt>value_url</dt><dd>is associated to bean's property <strong>valueUrl</strong></dd>
   * 	<dt>value_time</dt><dd>is associated to bean's property <strong>valueTime</strong></dd>
   * 	<dt>value_currency</dt><dd>is associated to bean's property <strong>valueCurrency</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is associated to bean's property <strong>valueTimeZone</strong></dd>
   * 	<dt>value_time_list</dt><dd>is associated to bean's property <strong>valueTimeList</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is associated to bean's property <strong>valueStrinList</strong></dd>
   * 	<dt>value_long_list</dt><dd>is associated to bean's property <strong>valueLongList</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is associated to bean's property <strong>valueByteArray</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is associated to bean's property <strong>valueLongTypeArray</strong></dd>
   * 	<dt>value_long_array</dt><dd>is associated to bean's property <strong>valueLongArray</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is associated to bean's property <strong>valueBeanArray</strong></dd>
   * 	<dt>value_string_array</dt><dd>is associated to bean's property <strong>valueStringArray</strong></dd>
   * 	<dt>value_char_list</dt><dd>is associated to bean's property <strong>valueCharList</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is associated to bean's property <strong>valueCharTypeArray</strong></dd>
   * 	<dt>value_char_array</dt><dd>is associated to bean's property <strong>valueCharArray</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is associated to bean's property <strong>valueMapStringBean</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is associated to bean's property <strong>valueLinkedMapStringBean</strong></dd>
   * 	<dt>value_set_string</dt><dd>is associated to bean's property <strong>valueSetString</strong></dd>
   * 	<dt>id</dt><dd>is associated to bean's property <strong>id</strong></dd>
   * </dl>
   * 
   * <h2>Query's parameters:</h2>
   * <dl>
   * 	<dt>${valueUrl}</dt><dd>is binded to method's parameter <strong>valueUrl</strong></dd>
   * </dl>.
   *
   * @param valueUrl 	is binded to <code>${valueUrl}</code>
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean selectOneURL(URL valueUrl) {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_ONE_U_R_L_SQL35;
    // add where arguments
    _contentValues.addWhereArgs((valueUrl==null?"":UrlUtils.write(valueUrl)));
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END

      Bean resultBean=null;

      if (_cursor.moveToFirst()) {

        int index0=_cursor.getColumnIndex("value_bool_type");
        int index1=_cursor.getColumnIndex("value_bool");
        int index2=_cursor.getColumnIndex("value_byte_type");
        int index3=_cursor.getColumnIndex("value_byte");
        int index4=_cursor.getColumnIndex("value_short_type");
        int index5=_cursor.getColumnIndex("value_short");
        int index6=_cursor.getColumnIndex("value_int_type");
        int index7=_cursor.getColumnIndex("value_int");
        int index8=_cursor.getColumnIndex("value_string");
        int index9=_cursor.getColumnIndex("value_char_type");
        int index10=_cursor.getColumnIndex("value_char");
        int index11=_cursor.getColumnIndex("value_float_type");
        int index12=_cursor.getColumnIndex("value_float");
        int index13=_cursor.getColumnIndex("value_big_integer");
        int index14=_cursor.getColumnIndex("value_big_decimal");
        int index15=_cursor.getColumnIndex("value_enum_type");
        int index16=_cursor.getColumnIndex("value_long_type");
        int index17=_cursor.getColumnIndex("value_long");
        int index18=_cursor.getColumnIndex("value_double_type");
        int index19=_cursor.getColumnIndex("value_double");
        int index20=_cursor.getColumnIndex("value_locale");
        int index21=_cursor.getColumnIndex("value_calendar");
        int index22=_cursor.getColumnIndex("value_date");
        int index23=_cursor.getColumnIndex("value_url");
        int index24=_cursor.getColumnIndex("value_time");
        int index25=_cursor.getColumnIndex("value_currency");
        int index26=_cursor.getColumnIndex("value_time_zone");
        int index27=_cursor.getColumnIndex("value_time_list");
        int index28=_cursor.getColumnIndex("value_strin_list");
        int index29=_cursor.getColumnIndex("value_long_list");
        int index30=_cursor.getColumnIndex("value_byte_array");
        int index31=_cursor.getColumnIndex("value_long_type_array");
        int index32=_cursor.getColumnIndex("value_long_array");
        int index33=_cursor.getColumnIndex("value_bean_array");
        int index34=_cursor.getColumnIndex("value_string_array");
        int index35=_cursor.getColumnIndex("value_char_list");
        int index36=_cursor.getColumnIndex("value_char_type_array");
        int index37=_cursor.getColumnIndex("value_char_array");
        int index38=_cursor.getColumnIndex("value_map_string_bean");
        int index39=_cursor.getColumnIndex("value_linked_map_string_bean");
        int index40=_cursor.getColumnIndex("value_set_string");
        int index41=_cursor.getColumnIndex("id");

        resultBean=new Bean();

        if (!_cursor.isNull(index0)) { resultBean.valueBoolType=_cursor.getInt(index0)==0?false:true; }
        if (!_cursor.isNull(index1)) { resultBean.valueBool=_cursor.getInt(index1)==0?false:true; }
        if (!_cursor.isNull(index2)) { resultBean.valueByteType=(byte)_cursor.getInt(index2); }
        if (!_cursor.isNull(index3)) { resultBean.valueByte=(byte)_cursor.getInt(index3); }
        if (!_cursor.isNull(index4)) { resultBean.valueShortType=_cursor.getShort(index4); }
        if (!_cursor.isNull(index5)) { resultBean.valueShort=_cursor.getShort(index5); }
        if (!_cursor.isNull(index6)) { resultBean.valueIntType=_cursor.getInt(index6); }
        if (!_cursor.isNull(index7)) { resultBean.valueInt=_cursor.getInt(index7); }
        if (!_cursor.isNull(index8)) { resultBean.valueString=_cursor.getString(index8); }
        if (!_cursor.isNull(index9)) { resultBean.valueCharType=(char)_cursor.getInt(index9); }
        if (!_cursor.isNull(index10)) { resultBean.valueChar=(char)_cursor.getInt(index10); }
        if (!_cursor.isNull(index11)) { resultBean.valueFloatType=_cursor.getFloat(index11); }
        if (!_cursor.isNull(index12)) { resultBean.valueFloat=_cursor.getFloat(index12); }
        if (!_cursor.isNull(index13)) { resultBean.valueBigInteger=new BigInteger(_cursor.getString(index13)); }
        if (!_cursor.isNull(index14)) { resultBean.valueBigDecimal=new BigDecimal(_cursor.getString(index14)); }
        if (!_cursor.isNull(index15)) { resultBean.valueEnumType=EnumType.valueOf(_cursor.getString(index15)); }
        if (!_cursor.isNull(index16)) { resultBean.valueLongType=_cursor.getLong(index16); }
        if (!_cursor.isNull(index17)) { resultBean.valueLong=_cursor.getLong(index17); }
        if (!_cursor.isNull(index18)) { resultBean.valueDoubleType=_cursor.getDouble(index18); }
        if (!_cursor.isNull(index19)) { resultBean.valueDouble=_cursor.getDouble(index19); }
        if (!_cursor.isNull(index20)) { resultBean.valueLocale=LocaleUtils.read(_cursor.getString(index20)); }
        if (!_cursor.isNull(index21)) { resultBean.valueCalendar=CalendarUtils.read(_cursor.getString(index21)); }
        if (!_cursor.isNull(index22)) { resultBean.valueDate=DateUtils.read(_cursor.getString(index22)); }
        if (!_cursor.isNull(index23)) { resultBean.valueUrl=UrlUtils.read(_cursor.getString(index23)); }
        if (!_cursor.isNull(index24)) { resultBean.valueTime=SQLTimeUtils.read(_cursor.getString(index24)); }
        if (!_cursor.isNull(index25)) { resultBean.valueCurrency=CurrencyUtils.read(_cursor.getString(index25)); }
        if (!_cursor.isNull(index26)) { resultBean.valueTimeZone=TimeZoneUtils.read(_cursor.getString(index26)); }
        if (!_cursor.isNull(index27)) { resultBean.valueTimeList=BeanTable.parseValueTimeList(_cursor.getBlob(index27)); }
        if (!_cursor.isNull(index28)) { resultBean.valueStrinList=BeanTable.parseValueStrinList(_cursor.getBlob(index28)); }
        if (!_cursor.isNull(index29)) { resultBean.valueLongList=BeanTable.parseValueLongList(_cursor.getBlob(index29)); }
        if (!_cursor.isNull(index30)) { resultBean.valueByteArray=_cursor.getBlob(index30); }
        if (!_cursor.isNull(index31)) { resultBean.valueLongTypeArray=BeanTable.parseValueLongTypeArray(_cursor.getBlob(index31)); }
        if (!_cursor.isNull(index32)) { resultBean.valueLongArray=BeanTable.parseValueLongArray(_cursor.getBlob(index32)); }
        if (!_cursor.isNull(index33)) { resultBean.valueBeanArray=BeanTable.parseValueBeanArray(_cursor.getBlob(index33)); }
        if (!_cursor.isNull(index34)) { resultBean.valueStringArray=BeanTable.parseValueStringArray(_cursor.getBlob(index34)); }
        if (!_cursor.isNull(index35)) { resultBean.valueCharList=BeanTable.parseValueCharList(_cursor.getBlob(index35)); }
        if (!_cursor.isNull(index36)) { resultBean.valueCharTypeArray=BeanTable.parseValueCharTypeArray(_cursor.getBlob(index36)); }
        if (!_cursor.isNull(index37)) { resultBean.valueCharArray=BeanTable.parseValueCharArray(_cursor.getBlob(index37)); }
        if (!_cursor.isNull(index38)) { resultBean.valueMapStringBean=BeanTable.parseValueMapStringBean(_cursor.getBlob(index38)); }
        if (!_cursor.isNull(index39)) { resultBean.valueLinkedMapStringBean=BeanTable.parseValueLinkedMapStringBean(_cursor.getBlob(index39)); }
        if (!_cursor.isNull(index40)) { resultBean.valueSetString=BeanTable.parseValueSetString(_cursor.getBlob(index40)); }
        resultBean.id=_cursor.getLong(index41);

      }
      return resultBean;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool</dt><dd>is associated to bean's property <strong>valueBool</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public Boolean selectValueBool() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_BOOL_SQL36;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      Boolean result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=_cursor.getInt(0)==0?false:true;
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_bool_type FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is associated to bean's property <strong>valueBoolType</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public boolean selectValueBoolType() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_BOOL_TYPE_SQL37;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      boolean result=false;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return false; }
        result=_cursor.getInt(0)==0?false:true;
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_byte FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_byte</dt><dd>is associated to bean's property <strong>valueByte</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public Byte selectValueByte() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_BYTE_SQL38;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      Byte result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=(byte)_cursor.getInt(0);
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_byte_type FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_byte_type</dt><dd>is associated to bean's property <strong>valueByteType</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public byte selectValueByteType() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_BYTE_TYPE_SQL39;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      byte result=0;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return 0; }
        result=(byte)_cursor.getInt(0);
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_char FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_char</dt><dd>is associated to bean's property <strong>valueChar</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public Character selectValueChar() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_CHAR_SQL40;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      Character result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=(char)_cursor.getInt(0);
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_char_type FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_char_type</dt><dd>is associated to bean's property <strong>valueCharType</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public char selectValueCharType() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_CHAR_TYPE_SQL41;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      char result=0;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return 0; }
        result=(char)_cursor.getInt(0);
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_double FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_double</dt><dd>is associated to bean's property <strong>valueDouble</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public Double selectValueDouble() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_DOUBLE_SQL42;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      Double result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=_cursor.getDouble(0);
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_double_type FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_double_type</dt><dd>is associated to bean's property <strong>valueDoubleType</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public double selectValueDoubleType() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_DOUBLE_TYPE_SQL43;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      double result=0;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return 0; }
        result=_cursor.getDouble(0);
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_float FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_float</dt><dd>is associated to bean's property <strong>valueFloat</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public Float selectValueFloat() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_FLOAT_SQL44;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      Float result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=_cursor.getFloat(0);
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_float_type FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_float_type</dt><dd>is associated to bean's property <strong>valueFloatType</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public float selectValueFloatType() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_FLOAT_TYPE_SQL45;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      float result=0f;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return 0f; }
        result=_cursor.getFloat(0);
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_int FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_int</dt><dd>is associated to bean's property <strong>valueInt</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public Integer selectValueInt() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_INT_SQL46;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      Integer result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=_cursor.getInt(0);
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_int_type FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_int_type</dt><dd>is associated to bean's property <strong>valueIntType</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public int selectValueIntType() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_INT_TYPE_SQL47;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      int result=0;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return 0; }
        result=_cursor.getInt(0);
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_long FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_long</dt><dd>is associated to bean's property <strong>valueLong</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public Long selectValueLong() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_LONG_SQL48;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      Long result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=_cursor.getLong(0);
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_long_type FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_long_type</dt><dd>is associated to bean's property <strong>valueLongType</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public long selectValueLongType() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_LONG_TYPE_SQL49;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      long result=0L;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return 0L; }
        result=_cursor.getLong(0);
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_short FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_short</dt><dd>is associated to bean's property <strong>valueShort</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public Short selectValueShort() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_SHORT_SQL50;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      Short result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=_cursor.getShort(0);
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_short_type FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_short_type</dt><dd>is associated to bean's property <strong>valueShortType</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public short selectValueShortType() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_SHORT_TYPE_SQL51;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      short result=0;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return 0; }
        result=_cursor.getShort(0);
      }
      return result;
    }
  }

  /**
   * <h2>Select SQL:</h2>
   * 
   * <pre>SELECT value_string FROM bean</pre>
   * 
   * <h2>Projected columns:</h2>
   * <dl>
   * 	<dt>value_string</dt><dd>is associated to bean's property <strong>valueString</strong></dd>
   * </dl>.
   *
   * @return single value extracted by query.
   */
  @Override
  public String selectValueString() {
    KriptonContentValues _contentValues=contentValues();
    // query SQL is statically defined
    String _sql=SELECT_VALUE_STRING_SQL52;
    // add where arguments
    String[] _sqlArgs=_contentValues.whereArgsAsArray();
    // log section BEGIN
    if (_context.isLogEnabled()) {
      // manage log
      Logger.info(_sql);

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    try (Cursor _cursor = database().rawQuery(_sql, _sqlArgs)) {
      // log section BEGIN
      if (_context.isLogEnabled()) {
        Logger.info("Rows found: %s",_cursor.getCount());
      }
      // log section END
      String result=null;

      if (_cursor.moveToFirst()) {

        if (_cursor.isNull(0)) { return null; }
        result=_cursor.getString(0);
      }
      return result;
    }
  }

  /**
   * <h2>SQL update:</h2>
   * <pre>UPDATE bean SET value_bool_type=:valueBoolType, value_bool=:valueBool, value_byte_type=:valueByteType, value_byte=:valueByte, value_short_type=:valueShortType, value_short=:valueShort, value_int_type=:valueIntType, value_int=:valueInt, value_string=:valueString, value_char_type=:valueCharType, value_char=:valueChar, value_float_type=:valueFloatType, value_float=:valueFloat, value_big_integer=:valueBigInteger, value_big_decimal=:valueBigDecimal, value_enum_type=:valueEnumType, value_long_type=:valueLongType, value_long=:valueLong, value_double_type=:valueDoubleType, value_double=:valueDouble, value_locale=:valueLocale, value_calendar=:valueCalendar, value_date=:valueDate, value_url=:valueUrl, value_time=:valueTime, value_currency=:valueCurrency, value_time_zone=:valueTimeZone, value_time_list=:valueTimeList, value_strin_list=:valueStrinList, value_long_list=:valueLongList, value_byte_array=:valueByteArray, value_long_type_array=:valueLongTypeArray, value_long_array=:valueLongArray, value_bean_array=:valueBeanArray, value_string_array=:valueStringArray, value_char_list=:valueCharList, value_char_type_array=:valueCharTypeArray, value_char_array=:valueCharArray, value_map_string_bean=:valueMapStringBean, value_linked_map_string_bean=:valueLinkedMapStringBean, value_set_string=:valueSetString WHERE id=${value.id}</pre>
   *
   * <h2>Updated columns:</h2>
   * <dl>
   * 	<dt>value_bool_type</dt><dd>is mapped to <strong>${value.valueBoolType}</strong></dd>
   * 	<dt>value_bool</dt><dd>is mapped to <strong>${value.valueBool}</strong></dd>
   * 	<dt>value_byte_type</dt><dd>is mapped to <strong>${value.valueByteType}</strong></dd>
   * 	<dt>value_byte</dt><dd>is mapped to <strong>${value.valueByte}</strong></dd>
   * 	<dt>value_short_type</dt><dd>is mapped to <strong>${value.valueShortType}</strong></dd>
   * 	<dt>value_short</dt><dd>is mapped to <strong>${value.valueShort}</strong></dd>
   * 	<dt>value_int_type</dt><dd>is mapped to <strong>${value.valueIntType}</strong></dd>
   * 	<dt>value_int</dt><dd>is mapped to <strong>${value.valueInt}</strong></dd>
   * 	<dt>value_string</dt><dd>is mapped to <strong>${value.valueString}</strong></dd>
   * 	<dt>value_char_type</dt><dd>is mapped to <strong>${value.valueCharType}</strong></dd>
   * 	<dt>value_char</dt><dd>is mapped to <strong>${value.valueChar}</strong></dd>
   * 	<dt>value_float_type</dt><dd>is mapped to <strong>${value.valueFloatType}</strong></dd>
   * 	<dt>value_float</dt><dd>is mapped to <strong>${value.valueFloat}</strong></dd>
   * 	<dt>value_big_integer</dt><dd>is mapped to <strong>${value.valueBigInteger}</strong></dd>
   * 	<dt>value_big_decimal</dt><dd>is mapped to <strong>${value.valueBigDecimal}</strong></dd>
   * 	<dt>value_enum_type</dt><dd>is mapped to <strong>${value.valueEnumType}</strong></dd>
   * 	<dt>value_long_type</dt><dd>is mapped to <strong>${value.valueLongType}</strong></dd>
   * 	<dt>value_long</dt><dd>is mapped to <strong>${value.valueLong}</strong></dd>
   * 	<dt>value_double_type</dt><dd>is mapped to <strong>${value.valueDoubleType}</strong></dd>
   * 	<dt>value_double</dt><dd>is mapped to <strong>${value.valueDouble}</strong></dd>
   * 	<dt>value_locale</dt><dd>is mapped to <strong>${value.valueLocale}</strong></dd>
   * 	<dt>value_calendar</dt><dd>is mapped to <strong>${value.valueCalendar}</strong></dd>
   * 	<dt>value_date</dt><dd>is mapped to <strong>${value.valueDate}</strong></dd>
   * 	<dt>value_url</dt><dd>is mapped to <strong>${value.valueUrl}</strong></dd>
   * 	<dt>value_time</dt><dd>is mapped to <strong>${value.valueTime}</strong></dd>
   * 	<dt>value_currency</dt><dd>is mapped to <strong>${value.valueCurrency}</strong></dd>
   * 	<dt>value_time_zone</dt><dd>is mapped to <strong>${value.valueTimeZone}</strong></dd>
   * 	<dt>value_time_list</dt><dd>is mapped to <strong>${value.valueTimeList}</strong></dd>
   * 	<dt>value_strin_list</dt><dd>is mapped to <strong>${value.valueStrinList}</strong></dd>
   * 	<dt>value_long_list</dt><dd>is mapped to <strong>${value.valueLongList}</strong></dd>
   * 	<dt>value_byte_array</dt><dd>is mapped to <strong>${value.valueByteArray}</strong></dd>
   * 	<dt>value_long_type_array</dt><dd>is mapped to <strong>${value.valueLongTypeArray}</strong></dd>
   * 	<dt>value_long_array</dt><dd>is mapped to <strong>${value.valueLongArray}</strong></dd>
   * 	<dt>value_bean_array</dt><dd>is mapped to <strong>${value.valueBeanArray}</strong></dd>
   * 	<dt>value_string_array</dt><dd>is mapped to <strong>${value.valueStringArray}</strong></dd>
   * 	<dt>value_char_list</dt><dd>is mapped to <strong>${value.valueCharList}</strong></dd>
   * 	<dt>value_char_type_array</dt><dd>is mapped to <strong>${value.valueCharTypeArray}</strong></dd>
   * 	<dt>value_char_array</dt><dd>is mapped to <strong>${value.valueCharArray}</strong></dd>
   * 	<dt>value_map_string_bean</dt><dd>is mapped to <strong>${value.valueMapStringBean}</strong></dd>
   * 	<dt>value_linked_map_string_bean</dt><dd>is mapped to <strong>${value.valueLinkedMapStringBean}</strong></dd>
   * 	<dt>value_set_string</dt><dd>is mapped to <strong>${value.valueSetString}</strong></dd>
   * </dl>
   *
   * <h2>Parameters used in where conditions:</h2>
   * <dl>
   * 	<dt>${value.id}</dt><dd>is mapped to method's parameter <strong>value.id</strong></dd>
   * </dl>
   *
   * @param value
   * 	is used as ${value}
   *
   * @return number of updated records
   */
  @Override
  public long updateOne(Bean value) {
    if (updateOnePreparedStatement63==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET value_bool_type=?, value_bool=?, value_byte_type=?, value_byte=?, value_short_type=?, value_short=?, value_int_type=?, value_int=?, value_string=?, value_char_type=?, value_char=?, value_float_type=?, value_float=?, value_big_integer=?, value_big_decimal=?, value_enum_type=?, value_long_type=?, value_long=?, value_double_type=?, value_double=?, value_locale=?, value_calendar=?, value_date=?, value_url=?, value_time=?, value_currency=?, value_time_zone=?, value_time_list=?, value_strin_list=?, value_long_list=?, value_byte_array=?, value_long_type_array=?, value_long_array=?, value_bean_array=?, value_string_array=?, value_char_list=?, value_char_type_array=?, value_char_array=?, value_map_string_bean=?, value_linked_map_string_bean=?, value_set_string=? WHERE id=?";
      updateOnePreparedStatement63 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOnePreparedStatement63);
    _contentValues.put("value_bool_type", value.valueBoolType);
    _contentValues.put("value_bool", value.valueBool);
    _contentValues.put("value_byte_type", value.valueByteType);
    _contentValues.put("value_byte", value.valueByte);
    _contentValues.put("value_short_type", value.valueShortType);
    _contentValues.put("value_short", value.valueShort);
    _contentValues.put("value_int_type", value.valueIntType);
    _contentValues.put("value_int", value.valueInt);
    _contentValues.put("value_string", value.valueString);
    _contentValues.put("value_char_type", value.valueCharType);
    _contentValues.put("value_char", value.valueChar);
    _contentValues.put("value_float_type", value.valueFloatType);
    _contentValues.put("value_float", value.valueFloat);
    _contentValues.put("value_big_integer", value.valueBigInteger);
    _contentValues.put("value_big_decimal", value.valueBigDecimal);
    _contentValues.put("value_enum_type", EnumUtils.write(value.valueEnumType));
    _contentValues.put("value_long_type", value.valueLongType);
    _contentValues.put("value_long", value.valueLong);
    _contentValues.put("value_double_type", value.valueDoubleType);
    _contentValues.put("value_double", value.valueDouble);
    _contentValues.put("value_locale", LocaleUtils.write(value.valueLocale));
    _contentValues.put("value_calendar", CalendarUtils.write(value.valueCalendar));
    _contentValues.put("value_date", DateUtils.write(value.valueDate));
    _contentValues.put("value_url", UrlUtils.write(value.valueUrl));
    _contentValues.put("value_time", SQLTimeUtils.write(value.valueTime));
    _contentValues.put("value_currency", CurrencyUtils.write(value.valueCurrency));
    _contentValues.put("value_time_zone", TimeZoneUtils.write(value.valueTimeZone));
    _contentValues.put("value_time_list", BeanTable.serializeValueTimeList(value.valueTimeList));
    _contentValues.put("value_strin_list", BeanTable.serializeValueStrinList(value.valueStrinList));
    _contentValues.put("value_long_list", BeanTable.serializeValueLongList(value.valueLongList));
    _contentValues.put("value_byte_array", value.valueByteArray);
    _contentValues.put("value_long_type_array", BeanTable.serializeValueLongTypeArray(value.valueLongTypeArray));
    _contentValues.put("value_long_array", BeanTable.serializeValueLongArray(value.valueLongArray));
    _contentValues.put("value_bean_array", BeanTable.serializeValueBeanArray(value.valueBeanArray));
    _contentValues.put("value_string_array", BeanTable.serializeValueStringArray(value.valueStringArray));
    _contentValues.put("value_char_list", BeanTable.serializeValueCharList(value.valueCharList));
    _contentValues.put("value_char_type_array", BeanTable.serializeValueCharTypeArray(value.valueCharTypeArray));
    _contentValues.put("value_char_array", BeanTable.serializeValueCharArray(value.valueCharArray));
    _contentValues.put("value_map_string_bean", BeanTable.serializeValueMapStringBean(value.valueMapStringBean));
    _contentValues.put("value_linked_map_string_bean", BeanTable.serializeValueLinkedMapStringBean(value.valueLinkedMapStringBean));
    _contentValues.put("value_set_string", BeanTable.serializeValueSetString(value.valueSetString));

    _contentValues.addWhereArgs(String.valueOf(value.id));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET value_bool_type=:value_bool_type, value_bool=:value_bool, value_byte_type=:value_byte_type, value_byte=:value_byte, value_short_type=:value_short_type, value_short=:value_short, value_int_type=:value_int_type, value_int=:value_int, value_string=:value_string, value_char_type=:value_char_type, value_char=:value_char, value_float_type=:value_float_type, value_float=:value_float, value_big_integer=:value_big_integer, value_big_decimal=:value_big_decimal, value_enum_type=:value_enum_type, value_long_type=:value_long_type, value_long=:value_long, value_double_type=:value_double_type, value_double=:value_double, value_locale=:value_locale, value_calendar=:value_calendar, value_date=:value_date, value_url=:value_url, value_time=:value_time, value_currency=:value_currency, value_time_zone=:value_time_zone, value_time_list=:value_time_list, value_strin_list=:value_strin_list, value_long_list=:value_long_list, value_byte_array=:value_byte_array, value_long_type_array=:value_long_type_array, value_long_array=:value_long_array, value_bean_array=:value_bean_array, value_string_array=:value_string_array, value_char_list=:value_char_list, value_char_type_array=:value_char_type_array, value_char_array=:value_char_array, value_map_string_bean=:value_map_string_bean, value_linked_map_string_bean=:value_linked_map_string_bean, value_set_string=:value_set_string WHERE id=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOnePreparedStatement63, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_big_decimal=${valueBigDecimal}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueBigDecimal}</dt><dd>is mapped to method's parameter <strong>valueBigDecimal</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueBigDecimal 	is used as where parameter <strong>${valueBigDecimal}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOne(long id, BigDecimal valueBigDecimal) {
    if (updateOnePreparedStatement64==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_big_decimal=?";
      updateOnePreparedStatement64 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOnePreparedStatement64);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueBigDecimal==null?"":valueBigDecimal.toPlainString()));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_big_decimal=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOnePreparedStatement64, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_big_decimal=${valueBigDecimal}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueBigDecimal}</dt><dd>is mapped to method's parameter <strong>valueBigDecimal</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueBigDecimal 	is used as where parameter <strong>${valueBigDecimal}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOne(long id, BigInteger valueBigDecimal) {
    if (updateOnePreparedStatement65==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_big_decimal=?";
      updateOnePreparedStatement65 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOnePreparedStatement65);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueBigDecimal==null?"":valueBigDecimal.toString()));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_big_decimal=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOnePreparedStatement65, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_bool_type=${valueBoolType}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueBoolType}</dt><dd>is mapped to method's parameter <strong>valueBoolType</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueBoolType 	is used as where parameter <strong>${valueBoolType}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOne(long id, boolean valueBoolType) {
    if (updateOnePreparedStatement66==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_bool_type=?";
      updateOnePreparedStatement66 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOnePreparedStatement66);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueBoolType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_bool_type=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOnePreparedStatement66, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_bool=${valueBool}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueBool}</dt><dd>is mapped to method's parameter <strong>valueBool</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueBool 	is used as where parameter <strong>${valueBool}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOne(long id, Boolean valueBool) {
    if (updateOnePreparedStatement67==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_bool=?";
      updateOnePreparedStatement67 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOnePreparedStatement67);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueBool==null?"":String.valueOf(valueBool)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_bool=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOnePreparedStatement67, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET value_set_string=:valueSetString WHERE id=${id}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>value_set_string</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${id}</dt><dd>is mapped to method's parameter <strong>id</strong></dd>
   * </dl>.
   *
   * @param id 	is used as where parameter <strong>${id}</strong>
   * @param valueSetString 	is used as updated field <strong>valueSetString</strong>
   * @return number of updated records
   */
  @Override
  public long updateOne(long id, Set<String> valueSetString) {
    if (updateOnePreparedStatement68==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET value_set_string=? WHERE id=?";
      updateOnePreparedStatement68 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOnePreparedStatement68);
    _contentValues.put("value_set_string", serializer5(valueSetString));

    _contentValues.addWhereArgs(String.valueOf(id));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET value_set_string=:value_set_string WHERE id=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOnePreparedStatement68, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_bean_array=${valueBeanArray}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueBeanArray}</dt><dd>is mapped to method's parameter <strong>valueBeanArray</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueBeanArray 	is used as where parameter <strong>${valueBeanArray}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneArrayBean(long id, Bean[] valueBeanArray) {
    if (updateOneArrayBeanPreparedStatement69==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_bean_array=?";
      updateOneArrayBeanPreparedStatement69 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneArrayBeanPreparedStatement69);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueBeanArray==null?"":new String(serializer1(valueBeanArray),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_bean_array=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneArrayBeanPreparedStatement69, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_long_array=${valueLongArray}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueLongArray}</dt><dd>is mapped to method's parameter <strong>valueLongArray</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueLongArray 	is used as where parameter <strong>${valueLongArray}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneArrayLong(long id, Long[] valueLongArray) {
    if (updateOneArrayLongPreparedStatement70==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_long_array=?";
      updateOneArrayLongPreparedStatement70 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneArrayLongPreparedStatement70);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueLongArray==null?"":new String(serializer2(valueLongArray),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_long_array=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneArrayLongPreparedStatement70, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_long_type_array=${valueLongTypeArray}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueLongTypeArray}</dt><dd>is mapped to method's parameter <strong>valueLongTypeArray</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueLongTypeArray 	is used as where parameter <strong>${valueLongTypeArray}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneArrayLongType(long id, long[] valueLongTypeArray) {
    if (updateOneArrayLongTypePreparedStatement71==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_long_type_array=?";
      updateOneArrayLongTypePreparedStatement71 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneArrayLongTypePreparedStatement71);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueLongTypeArray==null?"":new String(serializer3(valueLongTypeArray),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_long_type_array=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneArrayLongTypePreparedStatement71, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_byte=${valueByte}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueByte}</dt><dd>is mapped to method's parameter <strong>valueByte</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueByte 	is used as where parameter <strong>${valueByte}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneByte(long id, Byte valueByte) {
    if (updateOneBytePreparedStatement72==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_byte=?";
      updateOneBytePreparedStatement72 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneBytePreparedStatement72);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueByte==null?"":String.valueOf(valueByte)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_byte=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneBytePreparedStatement72, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_byte_type=${valueByteType}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueByteType}</dt><dd>is mapped to method's parameter <strong>valueByteType</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueByteType 	is used as where parameter <strong>${valueByteType}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneByteType(long id, boolean valueByteType) {
    if (updateOneByteTypePreparedStatement73==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_byte_type=?";
      updateOneByteTypePreparedStatement73 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneByteTypePreparedStatement73);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueByteType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_byte_type=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneByteTypePreparedStatement73, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_calendar=${valueCalendar}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueCalendar}</dt><dd>is mapped to method's parameter <strong>valueCalendar</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueCalendar 	is used as where parameter <strong>${valueCalendar}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneCalendar(long id, Calendar valueCalendar) {
    if (updateOneCalendarPreparedStatement74==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_calendar=?";
      updateOneCalendarPreparedStatement74 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneCalendarPreparedStatement74);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueCalendar==null?"":CalendarUtils.write(valueCalendar)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_calendar=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneCalendarPreparedStatement74, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_char_type=${valueChar}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueChar}</dt><dd>is mapped to method's parameter <strong>valueChar</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueChar 	is used as where parameter <strong>${valueChar}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneChar(long id, Character valueChar) {
    if (updateOneCharPreparedStatement75==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_char_type=?";
      updateOneCharPreparedStatement75 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneCharPreparedStatement75);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueChar==null?"":String.valueOf(valueChar)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_char_type=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneCharPreparedStatement75, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_char_type=${valueCharType}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueCharType}</dt><dd>is mapped to method's parameter <strong>valueCharType</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueCharType 	is used as where parameter <strong>${valueCharType}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneCharType(long id, char valueCharType) {
    if (updateOneCharTypePreparedStatement76==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_char_type=?";
      updateOneCharTypePreparedStatement76 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneCharTypePreparedStatement76);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueCharType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_char_type=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneCharTypePreparedStatement76, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_currency=${valueCurrency}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueCurrency}</dt><dd>is mapped to method's parameter <strong>valueCurrency</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueCurrency 	is used as where parameter <strong>${valueCurrency}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneCurrency(long id, Currency valueCurrency) {
    if (updateOneCurrencyPreparedStatement77==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_currency=?";
      updateOneCurrencyPreparedStatement77 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneCurrencyPreparedStatement77);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueCurrency==null?"":CurrencyUtils.write(valueCurrency)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_currency=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneCurrencyPreparedStatement77, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_date=${valueDate}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueDate}</dt><dd>is mapped to method's parameter <strong>valueDate</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueDate 	is used as where parameter <strong>${valueDate}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneDate(long id, Date valueDate) {
    if (updateOneDatePreparedStatement78==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_date=?";
      updateOneDatePreparedStatement78 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneDatePreparedStatement78);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueDate==null?"":DateUtils.write(valueDate)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_date=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneDatePreparedStatement78, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_double=${valueDouble}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueDouble}</dt><dd>is mapped to method's parameter <strong>valueDouble</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueDouble 	is used as where parameter <strong>${valueDouble}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneDouble(long id, Double valueDouble) {
    if (updateOneDoublePreparedStatement79==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_double=?";
      updateOneDoublePreparedStatement79 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneDoublePreparedStatement79);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueDouble==null?"":String.valueOf(valueDouble)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_double=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneDoublePreparedStatement79, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_double_type=${valueDoubleType}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueDoubleType}</dt><dd>is mapped to method's parameter <strong>valueDoubleType</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueDoubleType 	is used as where parameter <strong>${valueDoubleType}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneDoubleType(long id, double valueDoubleType) {
    if (updateOneDoubleTypePreparedStatement80==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_double_type=?";
      updateOneDoubleTypePreparedStatement80 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneDoubleTypePreparedStatement80);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueDoubleType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_double_type=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneDoubleTypePreparedStatement80, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_enum_type=${valueEnumType}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueEnumType}</dt><dd>is mapped to method's parameter <strong>valueEnumType</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueEnumType 	is used as where parameter <strong>${valueEnumType}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneEnumType(long id, EnumType valueEnumType) {
    if (updateOneEnumTypePreparedStatement81==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_enum_type=?";
      updateOneEnumTypePreparedStatement81 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneEnumTypePreparedStatement81);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueEnumType==null?"":EnumUtils.write(valueEnumType)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_enum_type=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneEnumTypePreparedStatement81, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_float=${valueFloat}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueFloat}</dt><dd>is mapped to method's parameter <strong>valueFloat</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueFloat 	is used as where parameter <strong>${valueFloat}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneFloat(long id, Float valueFloat) {
    if (updateOneFloatPreparedStatement82==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_float=?";
      updateOneFloatPreparedStatement82 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneFloatPreparedStatement82);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueFloat==null?"":String.valueOf(valueFloat)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_float=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneFloatPreparedStatement82, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_float_type=${valueFloatType}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueFloatType}</dt><dd>is mapped to method's parameter <strong>valueFloatType</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueFloatType 	is used as where parameter <strong>${valueFloatType}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneFloatType(long id, float valueFloatType) {
    if (updateOneFloatTypePreparedStatement83==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_float_type=?";
      updateOneFloatTypePreparedStatement83 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneFloatTypePreparedStatement83);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueFloatType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_float_type=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneFloatTypePreparedStatement83, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_int=${valueInt}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueInt}</dt><dd>is mapped to method's parameter <strong>valueInt</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueInt 	is used as where parameter <strong>${valueInt}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneInt(long id, Integer valueInt) {
    if (updateOneIntPreparedStatement84==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_int=?";
      updateOneIntPreparedStatement84 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneIntPreparedStatement84);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueInt==null?"":String.valueOf(valueInt)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_int=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneIntPreparedStatement84, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_int_type=${valueIntType}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueIntType}</dt><dd>is mapped to method's parameter <strong>valueIntType</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueIntType 	is used as where parameter <strong>${valueIntType}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneIntType(long id, int valueIntType) {
    if (updateOneIntTypePreparedStatement85==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_int_type=?";
      updateOneIntTypePreparedStatement85 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneIntTypePreparedStatement85);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueIntType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_int_type=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneIntTypePreparedStatement85, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_long_list=${valueLongList}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueLongList}</dt><dd>is mapped to method's parameter <strong>valueLongList</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueLongList 	is used as where parameter <strong>${valueLongList}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneListLong(long id, LinkedList<Long> valueLongList) {
    if (updateOneListLongPreparedStatement86==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_long_list=?";
      updateOneListLongPreparedStatement86 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneListLongPreparedStatement86);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueLongList==null?"":new String(serializer4(valueLongList),StandardCharsets.UTF_8)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_long_list=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneListLongPreparedStatement86, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_locale=${valueLocale}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueLocale}</dt><dd>is mapped to method's parameter <strong>valueLocale</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueLocale 	is used as where parameter <strong>${valueLocale}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneLocale(long id, Locale valueLocale) {
    if (updateOneLocalePreparedStatement87==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_locale=?";
      updateOneLocalePreparedStatement87 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneLocalePreparedStatement87);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueLocale==null?"":LocaleUtils.write(valueLocale)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_locale=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneLocalePreparedStatement87, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_long=${valueLong}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueLong}</dt><dd>is mapped to method's parameter <strong>valueLong</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueLong 	is used as where parameter <strong>${valueLong}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneLong(long id, Long valueLong) {
    if (updateOneLongPreparedStatement88==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_long=?";
      updateOneLongPreparedStatement88 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneLongPreparedStatement88);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueLong==null?"":String.valueOf(valueLong)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_long=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneLongPreparedStatement88, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_long_type=${valueLongType}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueLongType}</dt><dd>is mapped to method's parameter <strong>valueLongType</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueLongType 	is used as where parameter <strong>${valueLongType}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneLongType(long id, long valueLongType) {
    if (updateOneLongTypePreparedStatement89==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_long_type=?";
      updateOneLongTypePreparedStatement89 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneLongTypePreparedStatement89);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueLongType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_long_type=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneLongTypePreparedStatement89, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_short=${valueShort}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueShort}</dt><dd>is mapped to method's parameter <strong>valueShort</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueShort 	is used as where parameter <strong>${valueShort}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneShort(long id, Short valueShort) {
    if (updateOneShortPreparedStatement90==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_short=?";
      updateOneShortPreparedStatement90 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneShortPreparedStatement90);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueShort==null?"":String.valueOf(valueShort)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_short=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneShortPreparedStatement90, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_short_type=${valueShortType}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueShortType}</dt><dd>is mapped to method's parameter <strong>valueShortType</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueShortType 	is used as where parameter <strong>${valueShortType}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneShortType(long id, short valueShortType) {
    if (updateOneShortTypePreparedStatement91==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_short_type=?";
      updateOneShortTypePreparedStatement91 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneShortTypePreparedStatement91);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs(String.valueOf(valueShortType));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_short_type=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneShortTypePreparedStatement91, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_string=${valueString}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueString}</dt><dd>is mapped to method's parameter <strong>valueString</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueString 	is used as where parameter <strong>${valueString}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneString(long id, Double valueString) {
    if (updateOneStringPreparedStatement92==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_string=?";
      updateOneStringPreparedStatement92 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneStringPreparedStatement92);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueString==null?"":String.valueOf(valueString)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_string=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneStringPreparedStatement92, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_time=${valueTime}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueTime}</dt><dd>is mapped to method's parameter <strong>valueTime</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueTime 	is used as where parameter <strong>${valueTime}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneTime(long id, Time valueTime) {
    if (updateOneTimePreparedStatement93==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_time=?";
      updateOneTimePreparedStatement93 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneTimePreparedStatement93);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueTime==null?"":SQLTimeUtils.write(valueTime)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_time=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneTimePreparedStatement93, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_time_zone=${valueTimeZone}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueTimeZone}</dt><dd>is mapped to method's parameter <strong>valueTimeZone</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueTimeZone 	is used as where parameter <strong>${valueTimeZone}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneTimeZone(long id, TimeZone valueTimeZone) {
    if (updateOneTimeZonePreparedStatement94==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_time_zone=?";
      updateOneTimeZonePreparedStatement94 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneTimeZonePreparedStatement94);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueTimeZone==null?"":TimeZoneUtils.write(valueTimeZone)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_time_zone=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneTimeZonePreparedStatement94, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean SET id=:id WHERE value_url=${valueUrl}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>id</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${valueUrl}</dt><dd>is mapped to method's parameter <strong>valueUrl</strong></dd>
   * </dl>.
   *
   * @param id 	is used as updated field <strong>id</strong>
   * @param valueUrl 	is used as where parameter <strong>${valueUrl}</strong>
   * @return number of updated records
   */
  @Override
  public long updateOneURL(long id, URL valueUrl) {
    if (updateOneURLPreparedStatement95==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean SET id=? WHERE value_url=?";
      updateOneURLPreparedStatement95 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updateOneURLPreparedStatement95);
    _contentValues.put("id", id);

    _contentValues.addWhereArgs((valueUrl==null?"":UrlUtils.write(valueUrl)));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean SET id=:id WHERE value_url=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updateOneURLPreparedStatement95, _contentValues);
    return result;
  }

  /**
   * for param serializer1 serialization.
   *
   * @param value the value
   * @return the byte[]
   */
  private byte[] serializer1(Bean[] value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      int fieldCount=0;
      jacksonSerializer.writeStartObject();
      if (value!=null)  {
        int n=value.length;
        Bean item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value[i];
          if (item==null) {
            jacksonSerializer.writeNull();
          } else {
            beanBindMap.serializeOnJackson(item, jacksonSerializer);
          }
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for param parser1 parsing.
   *
   * @param input the input
   * @return the bean[]
   */
  private Bean[] parser1(byte[] input) {
    if (input==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (JacksonWrapperParser wrapper=context.createParser(input)) {
      JsonParser jacksonParser=wrapper.jacksonParser;
      // START_OBJECT
      jacksonParser.nextToken();
      // value of "element"
      jacksonParser.nextValue();
      Bean[] result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        ArrayList<Bean> collection=new ArrayList<>();
        Bean item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=beanBindMap.parseOnJackson(jacksonParser);
          }
          collection.add(item);
        }
        result=CollectionUtils.asArray(collection, new Bean[collection.size()]);
      }
      return result;
    } catch(Exception e) {
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for param serializer2 serialization.
   *
   * @param value the value
   * @return the byte[]
   */
  private byte[] serializer2(Long[] value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      int fieldCount=0;
      jacksonSerializer.writeStartObject();
      if (value!=null)  {
        int n=value.length;
        Long item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value[i];
          if (item==null) {
            jacksonSerializer.writeNull();
          } else {
            jacksonSerializer.writeNumber(item);
          }
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for param parser2 parsing.
   *
   * @param input the input
   * @return the long[]
   */
  private Long[] parser2(byte[] input) {
    if (input==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (JacksonWrapperParser wrapper=context.createParser(input)) {
      JsonParser jacksonParser=wrapper.jacksonParser;
      // START_OBJECT
      jacksonParser.nextToken();
      // value of "element"
      jacksonParser.nextValue();
      Long[] result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        ArrayList<Long> collection=new ArrayList<>();
        Long item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=jacksonParser.getLongValue();
          }
          collection.add(item);
        }
        result=CollectionUtils.asLongArray(collection);
      }
      return result;
    } catch(Exception e) {
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for param serializer5 serialization.
   *
   * @param value the value
   * @return the byte[]
   */
  private byte[] serializer5(Set<String> value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      int fieldCount=0;
      jacksonSerializer.writeStartObject();
      if (value!=null)  {
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (String item: value) {
          if (item==null) {
            jacksonSerializer.writeNull();
          } else {
            jacksonSerializer.writeString(item);
          }
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for param parser5 parsing.
   *
   * @param input the input
   * @return the sets the
   */
  private Set<String> parser5(byte[] input) {
    if (input==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (JacksonWrapperParser wrapper=context.createParser(input)) {
      JsonParser jacksonParser=wrapper.jacksonParser;
      // START_OBJECT
      jacksonParser.nextToken();
      // value of "element"
      jacksonParser.nextValue();
      Set<String> result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        HashSet<String> collection=new HashSet<>();
        String item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=jacksonParser.getText();
          }
          collection.add(item);
        }
        result=collection;
      }
      return result;
    } catch(Exception e) {
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for param serializer4 serialization.
   *
   * @param value the value
   * @return the byte[]
   */
  private byte[] serializer4(LinkedList<Long> value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      int fieldCount=0;
      jacksonSerializer.writeStartObject();
      if (value!=null)  {
        int n=value.size();
        Long item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value.get(i);
          if (item==null) {
            jacksonSerializer.writeNull();
          } else {
            jacksonSerializer.writeNumber(item);
          }
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for param parser4 parsing.
   *
   * @param input the input
   * @return the linked list
   */
  private LinkedList<Long> parser4(byte[] input) {
    if (input==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (JacksonWrapperParser wrapper=context.createParser(input)) {
      JsonParser jacksonParser=wrapper.jacksonParser;
      // START_OBJECT
      jacksonParser.nextToken();
      // value of "element"
      jacksonParser.nextValue();
      LinkedList<Long> result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        LinkedList<Long> collection=new LinkedList<>();
        Long item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=jacksonParser.getLongValue();
          }
          collection.add(item);
        }
        result=collection;
      }
      return result;
    } catch(Exception e) {
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for param serializer3 serialization.
   *
   * @param value the value
   * @return the byte[]
   */
  private byte[] serializer3(long[] value) {
    if (value==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (KriptonByteArrayOutputStream stream=new KriptonByteArrayOutputStream(); JacksonWrapperSerializer wrapper=context.createSerializer(stream)) {
      JsonGenerator jacksonSerializer=wrapper.jacksonGenerator;
      int fieldCount=0;
      jacksonSerializer.writeStartObject();
      if (value!=null)  {
        int n=value.length;
        long item;
        // write wrapper tag
        jacksonSerializer.writeFieldName("element");
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=value[i];
          jacksonSerializer.writeNumber(item);
        }
        jacksonSerializer.writeEndArray();
      }
      jacksonSerializer.writeEndObject();
      jacksonSerializer.flush();
      return stream.toByteArray();
    } catch(Exception e) {
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * for param parser3 parsing.
   *
   * @param input the input
   * @return the long[]
   */
  private long[] parser3(byte[] input) {
    if (input==null) {
      return null;
    }
    KriptonJsonContext context=KriptonBinder.jsonBind();
    try (JacksonWrapperParser wrapper=context.createParser(input)) {
      JsonParser jacksonParser=wrapper.jacksonParser;
      // START_OBJECT
      jacksonParser.nextToken();
      // value of "element"
      jacksonParser.nextValue();
      long[] result=null;
      if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
        ArrayList<Long> collection=new ArrayList<>();
        Long item=null;
        while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
          if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
            item=null;
          } else {
            item=jacksonParser.getLongValue();
          }
          collection.add(item);
        }
        result=CollectionUtils.asLongTypeArray(collection);
      }
      return result;
    } catch(Exception e) {
      throw(new KriptonRuntimeException(e.getMessage()));
    }
  }

  /**
   * Clear compiled statements.
   */
  public static void clearCompiledStatements() {
    if (deletePreparedStatement0!=null) {
      deletePreparedStatement0.close();
      deletePreparedStatement0=null;
    }
    if (deletePreparedStatement1!=null) {
      deletePreparedStatement1.close();
      deletePreparedStatement1=null;
    }
    if (deletePreparedStatement2!=null) {
      deletePreparedStatement2.close();
      deletePreparedStatement2=null;
    }
    if (deletePreparedStatement3!=null) {
      deletePreparedStatement3.close();
      deletePreparedStatement3=null;
    }
    if (deleteArrayBeanTypePreparedStatement4!=null) {
      deleteArrayBeanTypePreparedStatement4.close();
      deleteArrayBeanTypePreparedStatement4=null;
    }
    if (deleteArrayLongPreparedStatement5!=null) {
      deleteArrayLongPreparedStatement5.close();
      deleteArrayLongPreparedStatement5=null;
    }
    if (deleteArrayLongTypePreparedStatement6!=null) {
      deleteArrayLongTypePreparedStatement6.close();
      deleteArrayLongTypePreparedStatement6=null;
    }
    if (deleteBytePreparedStatement7!=null) {
      deleteBytePreparedStatement7.close();
      deleteBytePreparedStatement7=null;
    }
    if (deleteByteTypePreparedStatement8!=null) {
      deleteByteTypePreparedStatement8.close();
      deleteByteTypePreparedStatement8=null;
    }
    if (deleteCalendarPreparedStatement9!=null) {
      deleteCalendarPreparedStatement9.close();
      deleteCalendarPreparedStatement9=null;
    }
    if (deleteCharPreparedStatement10!=null) {
      deleteCharPreparedStatement10.close();
      deleteCharPreparedStatement10=null;
    }
    if (deleteCharTypePreparedStatement11!=null) {
      deleteCharTypePreparedStatement11.close();
      deleteCharTypePreparedStatement11=null;
    }
    if (deleteCurrencyPreparedStatement12!=null) {
      deleteCurrencyPreparedStatement12.close();
      deleteCurrencyPreparedStatement12=null;
    }
    if (deleteDatePreparedStatement13!=null) {
      deleteDatePreparedStatement13.close();
      deleteDatePreparedStatement13=null;
    }
    if (deleteDoublePreparedStatement14!=null) {
      deleteDoublePreparedStatement14.close();
      deleteDoublePreparedStatement14=null;
    }
    if (deleteDoubleTypePreparedStatement15!=null) {
      deleteDoubleTypePreparedStatement15.close();
      deleteDoubleTypePreparedStatement15=null;
    }
    if (deleteEnumTypePreparedStatement16!=null) {
      deleteEnumTypePreparedStatement16.close();
      deleteEnumTypePreparedStatement16=null;
    }
    if (deleteFloatPreparedStatement17!=null) {
      deleteFloatPreparedStatement17.close();
      deleteFloatPreparedStatement17=null;
    }
    if (deleteFloatTypePreparedStatement18!=null) {
      deleteFloatTypePreparedStatement18.close();
      deleteFloatTypePreparedStatement18=null;
    }
    if (deleteIntPreparedStatement19!=null) {
      deleteIntPreparedStatement19.close();
      deleteIntPreparedStatement19=null;
    }
    if (deleteIntTypePreparedStatement20!=null) {
      deleteIntTypePreparedStatement20.close();
      deleteIntTypePreparedStatement20=null;
    }
    if (deleteListLongPreparedStatement21!=null) {
      deleteListLongPreparedStatement21.close();
      deleteListLongPreparedStatement21=null;
    }
    if (deleteLocalePreparedStatement22!=null) {
      deleteLocalePreparedStatement22.close();
      deleteLocalePreparedStatement22=null;
    }
    if (deleteLongPreparedStatement23!=null) {
      deleteLongPreparedStatement23.close();
      deleteLongPreparedStatement23=null;
    }
    if (deleteLongTypePreparedStatement24!=null) {
      deleteLongTypePreparedStatement24.close();
      deleteLongTypePreparedStatement24=null;
    }
    if (deleteShortPreparedStatement25!=null) {
      deleteShortPreparedStatement25.close();
      deleteShortPreparedStatement25=null;
    }
    if (deleteShortTypePreparedStatement26!=null) {
      deleteShortTypePreparedStatement26.close();
      deleteShortTypePreparedStatement26=null;
    }
    if (deleteStringPreparedStatement27!=null) {
      deleteStringPreparedStatement27.close();
      deleteStringPreparedStatement27=null;
    }
    if (deleteTimePreparedStatement28!=null) {
      deleteTimePreparedStatement28.close();
      deleteTimePreparedStatement28=null;
    }
    if (deleteTimeZonePreparedStatement29!=null) {
      deleteTimeZonePreparedStatement29.close();
      deleteTimeZonePreparedStatement29=null;
    }
    if (deleteURLPreparedStatement30!=null) {
      deleteURLPreparedStatement30.close();
      deleteURLPreparedStatement30=null;
    }
    if (insertPreparedStatement31!=null) {
      insertPreparedStatement31.close();
      insertPreparedStatement31=null;
    }
    if (insertPreparedStatement32!=null) {
      insertPreparedStatement32.close();
      insertPreparedStatement32=null;
    }
    if (insertPreparedStatement33!=null) {
      insertPreparedStatement33.close();
      insertPreparedStatement33=null;
    }
    if (insertPreparedStatement34!=null) {
      insertPreparedStatement34.close();
      insertPreparedStatement34=null;
    }
    if (insertPreparedStatement35!=null) {
      insertPreparedStatement35.close();
      insertPreparedStatement35=null;
    }
    if (insertArrayBeanTypePreparedStatement36!=null) {
      insertArrayBeanTypePreparedStatement36.close();
      insertArrayBeanTypePreparedStatement36=null;
    }
    if (insertArrayLongPreparedStatement37!=null) {
      insertArrayLongPreparedStatement37.close();
      insertArrayLongPreparedStatement37=null;
    }
    if (insertArrayLongTypePreparedStatement38!=null) {
      insertArrayLongTypePreparedStatement38.close();
      insertArrayLongTypePreparedStatement38=null;
    }
    if (insertBytePreparedStatement39!=null) {
      insertBytePreparedStatement39.close();
      insertBytePreparedStatement39=null;
    }
    if (insertByteTypePreparedStatement40!=null) {
      insertByteTypePreparedStatement40.close();
      insertByteTypePreparedStatement40=null;
    }
    if (insertCalendarPreparedStatement41!=null) {
      insertCalendarPreparedStatement41.close();
      insertCalendarPreparedStatement41=null;
    }
    if (insertCharPreparedStatement42!=null) {
      insertCharPreparedStatement42.close();
      insertCharPreparedStatement42=null;
    }
    if (insertCharTypePreparedStatement43!=null) {
      insertCharTypePreparedStatement43.close();
      insertCharTypePreparedStatement43=null;
    }
    if (insertCurrencyPreparedStatement44!=null) {
      insertCurrencyPreparedStatement44.close();
      insertCurrencyPreparedStatement44=null;
    }
    if (insertDatePreparedStatement45!=null) {
      insertDatePreparedStatement45.close();
      insertDatePreparedStatement45=null;
    }
    if (insertDoublePreparedStatement46!=null) {
      insertDoublePreparedStatement46.close();
      insertDoublePreparedStatement46=null;
    }
    if (insertDoubleTypePreparedStatement47!=null) {
      insertDoubleTypePreparedStatement47.close();
      insertDoubleTypePreparedStatement47=null;
    }
    if (insertEnumTypePreparedStatement48!=null) {
      insertEnumTypePreparedStatement48.close();
      insertEnumTypePreparedStatement48=null;
    }
    if (insertFloatPreparedStatement49!=null) {
      insertFloatPreparedStatement49.close();
      insertFloatPreparedStatement49=null;
    }
    if (insertFloatTypePreparedStatement50!=null) {
      insertFloatTypePreparedStatement50.close();
      insertFloatTypePreparedStatement50=null;
    }
    if (insertIntPreparedStatement51!=null) {
      insertIntPreparedStatement51.close();
      insertIntPreparedStatement51=null;
    }
    if (insertIntTypePreparedStatement52!=null) {
      insertIntTypePreparedStatement52.close();
      insertIntTypePreparedStatement52=null;
    }
    if (insertListLongPreparedStatement53!=null) {
      insertListLongPreparedStatement53.close();
      insertListLongPreparedStatement53=null;
    }
    if (insertLocalePreparedStatement54!=null) {
      insertLocalePreparedStatement54.close();
      insertLocalePreparedStatement54=null;
    }
    if (insertLongPreparedStatement55!=null) {
      insertLongPreparedStatement55.close();
      insertLongPreparedStatement55=null;
    }
    if (insertLongTypePreparedStatement56!=null) {
      insertLongTypePreparedStatement56.close();
      insertLongTypePreparedStatement56=null;
    }
    if (insertShortPreparedStatement57!=null) {
      insertShortPreparedStatement57.close();
      insertShortPreparedStatement57=null;
    }
    if (insertShortTypePreparedStatement58!=null) {
      insertShortTypePreparedStatement58.close();
      insertShortTypePreparedStatement58=null;
    }
    if (insertStringPreparedStatement59!=null) {
      insertStringPreparedStatement59.close();
      insertStringPreparedStatement59=null;
    }
    if (insertTimePreparedStatement60!=null) {
      insertTimePreparedStatement60.close();
      insertTimePreparedStatement60=null;
    }
    if (insertTimeZonePreparedStatement61!=null) {
      insertTimeZonePreparedStatement61.close();
      insertTimeZonePreparedStatement61=null;
    }
    if (insertURLPreparedStatement62!=null) {
      insertURLPreparedStatement62.close();
      insertURLPreparedStatement62=null;
    }
    if (updateOnePreparedStatement63!=null) {
      updateOnePreparedStatement63.close();
      updateOnePreparedStatement63=null;
    }
    if (updateOnePreparedStatement64!=null) {
      updateOnePreparedStatement64.close();
      updateOnePreparedStatement64=null;
    }
    if (updateOnePreparedStatement65!=null) {
      updateOnePreparedStatement65.close();
      updateOnePreparedStatement65=null;
    }
    if (updateOnePreparedStatement66!=null) {
      updateOnePreparedStatement66.close();
      updateOnePreparedStatement66=null;
    }
    if (updateOnePreparedStatement67!=null) {
      updateOnePreparedStatement67.close();
      updateOnePreparedStatement67=null;
    }
    if (updateOnePreparedStatement68!=null) {
      updateOnePreparedStatement68.close();
      updateOnePreparedStatement68=null;
    }
    if (updateOneArrayBeanPreparedStatement69!=null) {
      updateOneArrayBeanPreparedStatement69.close();
      updateOneArrayBeanPreparedStatement69=null;
    }
    if (updateOneArrayLongPreparedStatement70!=null) {
      updateOneArrayLongPreparedStatement70.close();
      updateOneArrayLongPreparedStatement70=null;
    }
    if (updateOneArrayLongTypePreparedStatement71!=null) {
      updateOneArrayLongTypePreparedStatement71.close();
      updateOneArrayLongTypePreparedStatement71=null;
    }
    if (updateOneBytePreparedStatement72!=null) {
      updateOneBytePreparedStatement72.close();
      updateOneBytePreparedStatement72=null;
    }
    if (updateOneByteTypePreparedStatement73!=null) {
      updateOneByteTypePreparedStatement73.close();
      updateOneByteTypePreparedStatement73=null;
    }
    if (updateOneCalendarPreparedStatement74!=null) {
      updateOneCalendarPreparedStatement74.close();
      updateOneCalendarPreparedStatement74=null;
    }
    if (updateOneCharPreparedStatement75!=null) {
      updateOneCharPreparedStatement75.close();
      updateOneCharPreparedStatement75=null;
    }
    if (updateOneCharTypePreparedStatement76!=null) {
      updateOneCharTypePreparedStatement76.close();
      updateOneCharTypePreparedStatement76=null;
    }
    if (updateOneCurrencyPreparedStatement77!=null) {
      updateOneCurrencyPreparedStatement77.close();
      updateOneCurrencyPreparedStatement77=null;
    }
    if (updateOneDatePreparedStatement78!=null) {
      updateOneDatePreparedStatement78.close();
      updateOneDatePreparedStatement78=null;
    }
    if (updateOneDoublePreparedStatement79!=null) {
      updateOneDoublePreparedStatement79.close();
      updateOneDoublePreparedStatement79=null;
    }
    if (updateOneDoubleTypePreparedStatement80!=null) {
      updateOneDoubleTypePreparedStatement80.close();
      updateOneDoubleTypePreparedStatement80=null;
    }
    if (updateOneEnumTypePreparedStatement81!=null) {
      updateOneEnumTypePreparedStatement81.close();
      updateOneEnumTypePreparedStatement81=null;
    }
    if (updateOneFloatPreparedStatement82!=null) {
      updateOneFloatPreparedStatement82.close();
      updateOneFloatPreparedStatement82=null;
    }
    if (updateOneFloatTypePreparedStatement83!=null) {
      updateOneFloatTypePreparedStatement83.close();
      updateOneFloatTypePreparedStatement83=null;
    }
    if (updateOneIntPreparedStatement84!=null) {
      updateOneIntPreparedStatement84.close();
      updateOneIntPreparedStatement84=null;
    }
    if (updateOneIntTypePreparedStatement85!=null) {
      updateOneIntTypePreparedStatement85.close();
      updateOneIntTypePreparedStatement85=null;
    }
    if (updateOneListLongPreparedStatement86!=null) {
      updateOneListLongPreparedStatement86.close();
      updateOneListLongPreparedStatement86=null;
    }
    if (updateOneLocalePreparedStatement87!=null) {
      updateOneLocalePreparedStatement87.close();
      updateOneLocalePreparedStatement87=null;
    }
    if (updateOneLongPreparedStatement88!=null) {
      updateOneLongPreparedStatement88.close();
      updateOneLongPreparedStatement88=null;
    }
    if (updateOneLongTypePreparedStatement89!=null) {
      updateOneLongTypePreparedStatement89.close();
      updateOneLongTypePreparedStatement89=null;
    }
    if (updateOneShortPreparedStatement90!=null) {
      updateOneShortPreparedStatement90.close();
      updateOneShortPreparedStatement90=null;
    }
    if (updateOneShortTypePreparedStatement91!=null) {
      updateOneShortTypePreparedStatement91.close();
      updateOneShortTypePreparedStatement91=null;
    }
    if (updateOneStringPreparedStatement92!=null) {
      updateOneStringPreparedStatement92.close();
      updateOneStringPreparedStatement92=null;
    }
    if (updateOneTimePreparedStatement93!=null) {
      updateOneTimePreparedStatement93.close();
      updateOneTimePreparedStatement93=null;
    }
    if (updateOneTimeZonePreparedStatement94!=null) {
      updateOneTimeZonePreparedStatement94.close();
      updateOneTimeZonePreparedStatement94=null;
    }
    if (updateOneURLPreparedStatement95!=null) {
      updateOneURLPreparedStatement95.close();
      updateOneURLPreparedStatement95=null;
    }
  }
}
