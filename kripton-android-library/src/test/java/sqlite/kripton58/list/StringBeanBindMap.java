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
package sqlite.kripton58.list;

import com.abubusoft.kripton.AbstractMapper;
import com.abubusoft.kripton.annotation.BindMap;
import com.abubusoft.kripton.common.PrimitiveUtils;
import com.abubusoft.kripton.common.StringUtils;
import com.abubusoft.kripton.escape.StringEscapeUtils;
import com.abubusoft.kripton.xml.XMLParser;
import com.abubusoft.kripton.xml.XMLSerializer;
import com.abubusoft.kripton.xml.XmlAttributeUtils;
import com.abubusoft.kripton.xml.XmlPullParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;
import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * This class is binder map for StringBean.
 *
 * @see StringBean
 */
@BindMap(StringBean.class)
public class StringBeanBindMap extends AbstractMapper<StringBean> {
  
  /* (non-Javadoc)
   * @see com.abubusoft.kripton.BinderMapper#serializeOnJackson(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator)
   */
  @Override
  public int serializeOnJackson(StringBean object, JsonGenerator jacksonSerializer) throws
      Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field id (mapped with "id")
    fieldCount++;
    jacksonSerializer.writeNumberField("id", object.id);

    // field value (mapped with "value")
    if (object.value!=null)  {
      fieldCount++;
      int n=object.value.size();
      String item;
      // write wrapper tag
      jacksonSerializer.writeFieldName("value");
      jacksonSerializer.writeStartArray();
      for (int i=0; i<n; i++) {
        item=object.value.get(i);
        if (item==null) {
          jacksonSerializer.writeNull();
        } else {
          jacksonSerializer.writeString(item);
        }
      }
      jacksonSerializer.writeEndArray();
    }

    // field value2 (mapped with "value2")
    if (object.value2!=null)  {
      fieldCount++;
      int n=object.value2.size();
      String item;
      // write wrapper tag
      jacksonSerializer.writeFieldName("value2");
      jacksonSerializer.writeStartArray();
      for (int i=0; i<n; i++) {
        item=object.value2.get(i);
        if (item==null) {
          jacksonSerializer.writeNull();
        } else {
          jacksonSerializer.writeString(item);
        }
      }
      jacksonSerializer.writeEndArray();
    }

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  /* (non-Javadoc)
   * @see com.abubusoft.kripton.BinderMapper#serializeOnJacksonAsString(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator)
   */
  @Override
  public int serializeOnJacksonAsString(StringBean object, JsonGenerator jacksonSerializer) throws
      Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field id (mapped with "id")
    jacksonSerializer.writeStringField("id", PrimitiveUtils.writeLong(object.id));

    // field value (mapped with "value")
    if (object.value!=null)  {
      fieldCount++;
      int n=object.value.size();
      String item;
      // write wrapper tag
      jacksonSerializer.writeFieldName("value");
      if (n>0) {
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=object.value.get(i);
          if (item==null) {
            jacksonSerializer.writeString("null");
          } else {
            jacksonSerializer.writeString(item);
          }
        }
        jacksonSerializer.writeEndArray();
      } else {
        jacksonSerializer.writeString("");
      }
    }

    // field value2 (mapped with "value2")
    if (object.value2!=null)  {
      fieldCount++;
      int n=object.value2.size();
      String item;
      // write wrapper tag
      jacksonSerializer.writeFieldName("value2");
      if (n>0) {
        jacksonSerializer.writeStartArray();
        for (int i=0; i<n; i++) {
          item=object.value2.get(i);
          if (item==null) {
            jacksonSerializer.writeString("null");
          } else {
            jacksonSerializer.writeString(item);
          }
        }
        jacksonSerializer.writeEndArray();
      } else {
        jacksonSerializer.writeString("");
      }
    }

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  /**
   * method for xml serialization.
   *
   * @param object the object
   * @param xmlSerializer the xml serializer
   * @param currentEventType the current event type
   * @throws Exception the exception
   */
  @Override
  public void serializeOnXml(StringBean object, XMLSerializer xmlSerializer, int currentEventType)
      throws Exception {
    if (currentEventType == 0) {
      xmlSerializer.writeStartElement("stringBean");
    }

    // Persisted fields:

    // field id (mapped with "id")
    xmlSerializer.writeStartElement("id");
    xmlSerializer.writeLong(object.id);
    xmlSerializer.writeEndElement();

    // field value (mapped with "value")
    if (object.value!=null)  {
      int n=object.value.size();
      String item;
      for (int i=0; i<n; i++) {
        item=object.value.get(i);
        if (item==null) {
          xmlSerializer.writeEmptyElement("value");
        } else {
          xmlSerializer.writeStartElement("value");
          xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(item));
          xmlSerializer.writeEndElement();
        }
      }
      // to distinguish between first empty element and empty collection, we write an attribute emptyCollection
      if (n==0) {
        xmlSerializer.writeStartElement("value");
        xmlSerializer.writeAttribute("emptyCollection", "true");
        xmlSerializer.writeEndElement();
      }
    }

    // field value2 (mapped with "value2")
    if (object.value2!=null)  {
      int n=object.value2.size();
      String item;
      for (int i=0; i<n; i++) {
        item=object.value2.get(i);
        if (item==null) {
          xmlSerializer.writeEmptyElement("value2");
        } else {
          xmlSerializer.writeStartElement("value2");
          xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(item));
          xmlSerializer.writeEndElement();
        }
      }
      // to distinguish between first empty element and empty collection, we write an attribute emptyCollection
      if (n==0) {
        xmlSerializer.writeStartElement("value2");
        xmlSerializer.writeAttribute("emptyCollection", "true");
        xmlSerializer.writeEndElement();
      }
    }

    if (currentEventType == 0) {
      xmlSerializer.writeEndElement();
    }
  }

  /**
   * parse with jackson.
   *
   * @param jacksonParser the jackson parser
   * @return the string bean
   * @throws Exception the exception
   */
  @Override
  public StringBean parseOnJackson(JsonParser jacksonParser) throws Exception {
    StringBean instance = new StringBean();
    String fieldName;
    if (jacksonParser.currentToken() == null) {
      jacksonParser.nextToken();
    }
    if (jacksonParser.currentToken() != JsonToken.START_OBJECT) {
      jacksonParser.skipChildren();
      return instance;
    }
    while (jacksonParser.nextToken() != JsonToken.END_OBJECT) {
      fieldName = jacksonParser.getCurrentName();
      jacksonParser.nextToken();

      // Parse fields:
      switch (fieldName) {
          case "id":
            // field id (mapped with "id")
            instance.id=jacksonParser.getLongValue();
          break;
          case "value":
            // field value (mapped with "value")
            if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
              ArrayList<String> collection=new ArrayList<>();
              String item=null;
              while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
                if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
                  item=null;
                } else {
                  item=jacksonParser.getText();
                }
                collection.add(item);
              }
              instance.value=collection;
            }
          break;
          case "value2":
            // field value2 (mapped with "value2")
            if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
              LinkedList<String> collection=new LinkedList<>();
              String item=null;
              while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
                if (jacksonParser.currentToken()==JsonToken.VALUE_NULL) {
                  item=null;
                } else {
                  item=jacksonParser.getText();
                }
                collection.add(item);
              }
              instance.value2=collection;
            }
          break;
          default:
            jacksonParser.skipChildren();
          break;}
    }
    return instance;
  }

  /**
   * parse with jackson.
   *
   * @param jacksonParser the jackson parser
   * @return the string bean
   * @throws Exception the exception
   */
  @Override
  public StringBean parseOnJacksonAsString(JsonParser jacksonParser) throws Exception {
    StringBean instance = new StringBean();
    String fieldName;
    if (jacksonParser.getCurrentToken() == null) {
      jacksonParser.nextToken();
    }
    if (jacksonParser.getCurrentToken() != JsonToken.START_OBJECT) {
      jacksonParser.skipChildren();
      return instance;
    }
    while (jacksonParser.nextToken() != JsonToken.END_OBJECT) {
      fieldName = jacksonParser.getCurrentName();
      jacksonParser.nextToken();

      // Parse fields:
      switch (fieldName) {
          case "id":
            // field id (mapped with "id")
            instance.id=PrimitiveUtils.readLong(jacksonParser.getText(), 0L);
          break;
          case "value":
            // field value (mapped with "value")
            if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
              ArrayList<String> collection=new ArrayList<>();
              String item=null;
              String tempValue=null;
              while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
                tempValue=jacksonParser.getValueAsString();
                if (jacksonParser.currentToken()==JsonToken.VALUE_STRING && "null".equals(tempValue)) {
                  item=null;
                } else {
                  if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
                    item=jacksonParser.getText();
                  }
                }
                collection.add(item);
              }
              instance.value=collection;
            } else if (jacksonParser.currentToken()==JsonToken.VALUE_STRING && !StringUtils.hasText(jacksonParser.getValueAsString())) {
              ArrayList<String> collection=new ArrayList<>();
              instance.value=collection;
            }
          break;
          case "value2":
            // field value2 (mapped with "value2")
            if (jacksonParser.currentToken()==JsonToken.START_ARRAY) {
              LinkedList<String> collection=new LinkedList<>();
              String item=null;
              String tempValue=null;
              while (jacksonParser.nextToken() != JsonToken.END_ARRAY) {
                tempValue=jacksonParser.getValueAsString();
                if (jacksonParser.currentToken()==JsonToken.VALUE_STRING && "null".equals(tempValue)) {
                  item=null;
                } else {
                  if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
                    item=jacksonParser.getText();
                  }
                }
                collection.add(item);
              }
              instance.value2=collection;
            } else if (jacksonParser.currentToken()==JsonToken.VALUE_STRING && !StringUtils.hasText(jacksonParser.getValueAsString())) {
              LinkedList<String> collection=new LinkedList<>();
              instance.value2=collection;
            }
          break;
          default:
            jacksonParser.skipChildren();
          break;}
    }
    return instance;
  }

  /**
   * parse xml.
   *
   * @param xmlParser the xml parser
   * @param currentEventType the current event type
   * @return the string bean
   * @throws Exception the exception
   */
  @Override
  public StringBean parseOnXml(XMLParser xmlParser, int currentEventType) throws Exception {
    StringBean instance = new StringBean();
    int eventType = currentEventType;
    boolean read=true;

    if (currentEventType == 0) {
      eventType = xmlParser.next();
    } else {
      eventType = xmlParser.getEventType();
    }
    String currentTag = xmlParser.getName().toString();
    String elementName = currentTag;
    // No attributes found

    //sub-elements
    while (xmlParser.hasNext() && elementName!=null) {
      if (read) {
        eventType = xmlParser.next();
      } else {
        eventType = xmlParser.getEventType();
      }
      read=true;
      switch(eventType) {
          case XmlPullParser.START_TAG:
            currentTag = xmlParser.getName().toString();
            switch(currentTag) {
                case "id":
                  // property id (mapped on "id")
                  instance.id=PrimitiveUtils.readLong(xmlParser.getElementAsLong(), 0L);
                break;
                case "value":
                  // property value (mapped on "value")
                   {
                    ArrayList<String> collection=new ArrayList<>();
                    String item;
                    // add first element
                    item=null;
                    if (xmlParser.isEmptyElement()) {
                      // if there's a an empty collection it marked with attribute emptyCollection
                      if (XmlAttributeUtils.getAttributeAsBoolean(xmlParser, "emptyCollection", false)==false) {
                        collection.add(item);
                      }
                      xmlParser.nextTag();
                    } else {
                      item=StringEscapeUtils.unescapeXml(xmlParser.getElementText());
                      collection.add(item);
                    }
                    while (xmlParser.nextTag() != XmlPullParser.END_TAG && xmlParser.getName().toString().equals("value")) {
                      if (xmlParser.isEmptyElement()) {
                        item=null;
                        xmlParser.nextTag();
                      } else {
                        item=StringEscapeUtils.unescapeXml(xmlParser.getElementText());
                      }
                      collection.add(item);
                    }
                    instance.value=collection;
                    read=false;
                  }
                break;
                case "value2":
                  // property value2 (mapped on "value2")
                   {
                    LinkedList<String> collection=new LinkedList<>();
                    String item;
                    // add first element
                    item=null;
                    if (xmlParser.isEmptyElement()) {
                      // if there's a an empty collection it marked with attribute emptyCollection
                      if (XmlAttributeUtils.getAttributeAsBoolean(xmlParser, "emptyCollection", false)==false) {
                        collection.add(item);
                      }
                      xmlParser.nextTag();
                    } else {
                      item=StringEscapeUtils.unescapeXml(xmlParser.getElementText());
                      collection.add(item);
                    }
                    while (xmlParser.nextTag() != XmlPullParser.END_TAG && xmlParser.getName().toString().equals("value2")) {
                      if (xmlParser.isEmptyElement()) {
                        item=null;
                        xmlParser.nextTag();
                      } else {
                        item=StringEscapeUtils.unescapeXml(xmlParser.getElementText());
                      }
                      collection.add(item);
                    }
                    instance.value2=collection;
                    read=false;
                  }
                break;
                default:
                break;
              }
            break;
            case XmlPullParser.END_TAG:
              if (elementName.equals(xmlParser.getName())) {
                currentTag = elementName;
                elementName = null;
              }
            break;
            case XmlPullParser.CDSECT:
            case XmlPullParser.TEXT:
              // no property is binded to VALUE o CDATA break;
            default:
            break;
        }
      }
      return instance;
    }
  }
