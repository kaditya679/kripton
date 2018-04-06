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
package sqlite.kripton38;

import com.abubusoft.kripton.AbstractMapper;
import com.abubusoft.kripton.annotation.BindMap;
import com.abubusoft.kripton.common.Base64Utils;
import com.abubusoft.kripton.common.DateUtils;
import com.abubusoft.kripton.common.PrimitiveUtils;
import com.abubusoft.kripton.common.StringUtils;
import com.abubusoft.kripton.escape.StringEscapeUtils;
import com.abubusoft.kripton.xml.XMLParser;
import com.abubusoft.kripton.xml.XMLSerializer;
import com.abubusoft.kripton.xml.XmlPullParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

// TODO: Auto-generated Javadoc
/**
 * This class is binder map for Bean05.
 *
 * @see Bean05
 */
@BindMap(Bean05.class)
public class Bean05BindMap extends AbstractMapper<Bean05> {
  
  /* (non-Javadoc)
   * @see com.abubusoft.kripton.BinderMapper#serializeOnJackson(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator)
   */
  @Override
  public int serializeOnJackson(Bean05 object, JsonGenerator jacksonSerializer) throws Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field beanType (mapped with "beanType")
    if (object.getBeanType()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("beanType", object.getBeanType().toString());
    }

    // field content (mapped with "content")
    if (object.getContent()!=null)  {
      fieldCount++;
      jacksonSerializer.writeBinaryField("content", object.getContent());
    }

    // field creationTime (mapped with "creationTime")
    if (object.getCreationTime()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("creationTime", DateUtils.write(object.getCreationTime()));
    }

    // field number (mapped with "number")
    fieldCount++;
    jacksonSerializer.writeNumberField("number", object.getNumber());

    // field pk (mapped with "pk")
    fieldCount++;
    jacksonSerializer.writeNumberField("pk", object.getPk());

    // field text (mapped with "text")
    if (object.getText()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("text", object.getText());
    }

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  /* (non-Javadoc)
   * @see com.abubusoft.kripton.BinderMapper#serializeOnJacksonAsString(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator)
   */
  @Override
  public int serializeOnJacksonAsString(Bean05 object, JsonGenerator jacksonSerializer) throws
      Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field beanType (mapped with "beanType")
    if (object.getBeanType()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("beanType", object.getBeanType().toString());
    }

    // field content (mapped with "content")
    if (object.getContent()!=null)  {
      fieldCount++;
      jacksonSerializer.writeBinaryField("content", object.getContent());
    }

    // field creationTime (mapped with "creationTime")
    if (object.getCreationTime()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("creationTime", DateUtils.write(object.getCreationTime()));
    }

    // field number (mapped with "number")
    jacksonSerializer.writeStringField("number", PrimitiveUtils.writeLong(object.getNumber()));

    // field pk (mapped with "pk")
    jacksonSerializer.writeStringField("pk", PrimitiveUtils.writeLong(object.getPk()));

    // field text (mapped with "text")
    if (object.getText()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("text", object.getText());
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
  public void serializeOnXml(Bean05 object, XMLSerializer xmlSerializer, int currentEventType)
      throws Exception {
    if (currentEventType == 0) {
      xmlSerializer.writeStartElement("bean05");
    }

    // Persisted fields:

    // field beanType (mapped with "beanType")
    if (object.getBeanType()!=null)  {
      xmlSerializer.writeStartElement("beanType");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(object.getBeanType().toString()));
      xmlSerializer.writeEndElement();
    }

    // field content (mapped with "content")
    if (object.getContent()!=null) {
      xmlSerializer.writeStartElement("content");
      xmlSerializer.writeBinary(object.getContent());
      xmlSerializer.writeEndElement();
    }

    // field creationTime (mapped with "creationTime")
    if (object.getCreationTime()!=null)  {
      xmlSerializer.writeStartElement("creationTime");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(DateUtils.write(object.getCreationTime())));
      xmlSerializer.writeEndElement();
    }

    // field number (mapped with "number")
    xmlSerializer.writeStartElement("number");
    xmlSerializer.writeLong(object.getNumber());
    xmlSerializer.writeEndElement();

    // field pk (mapped with "pk")
    xmlSerializer.writeStartElement("pk");
    xmlSerializer.writeLong(object.getPk());
    xmlSerializer.writeEndElement();

    // field text (mapped with "text")
    if (object.getText()!=null) {
      xmlSerializer.writeStartElement("text");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(object.getText()));
      xmlSerializer.writeEndElement();
    }

    if (currentEventType == 0) {
      xmlSerializer.writeEndElement();
    }
  }

  /**
   * parse with jackson.
   *
   * @param jacksonParser the jackson parser
   * @return the bean 05
   * @throws Exception the exception
   */
  @Override
  public Bean05 parseOnJackson(JsonParser jacksonParser) throws Exception {
    Bean05 instance = new Bean05();
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
          case "beanType":
            // field beanType (mapped with "beanType")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              String tempEnum=jacksonParser.getText();
              instance.setBeanType(StringUtils.hasText(tempEnum)?BeanType.valueOf(tempEnum):null);
            }
          break;
          case "content":
            // field content (mapped with "content")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setContent(jacksonParser.getBinaryValue());
            }
          break;
          case "creationTime":
            // field creationTime (mapped with "creationTime")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setCreationTime(DateUtils.read(jacksonParser.getText()));
            }
          break;
          case "number":
            // field number (mapped with "number")
            instance.setNumber(jacksonParser.getLongValue());
          break;
          case "pk":
            // field pk (mapped with "pk")
            instance.setPk(jacksonParser.getLongValue());
          break;
          case "text":
            // field text (mapped with "text")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setText(jacksonParser.getText());
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
   * @return the bean 05
   * @throws Exception the exception
   */
  @Override
  public Bean05 parseOnJacksonAsString(JsonParser jacksonParser) throws Exception {
    Bean05 instance = new Bean05();
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
          case "beanType":
            // field beanType (mapped with "beanType")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              String tempEnum=jacksonParser.getText();
              instance.setBeanType(StringUtils.hasText(tempEnum)?BeanType.valueOf(tempEnum):null);
            }
          break;
          case "content":
            // field content (mapped with "content")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setContent(Base64Utils.decode(jacksonParser.getValueAsString()));
            }
          break;
          case "creationTime":
            // field creationTime (mapped with "creationTime")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setCreationTime(DateUtils.read(jacksonParser.getText()));
            }
          break;
          case "number":
            // field number (mapped with "number")
            instance.setNumber(PrimitiveUtils.readLong(jacksonParser.getText(), 0L));
          break;
          case "pk":
            // field pk (mapped with "pk")
            instance.setPk(PrimitiveUtils.readLong(jacksonParser.getText(), 0L));
          break;
          case "text":
            // field text (mapped with "text")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setText(jacksonParser.getText());
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
   * @return the bean 05
   * @throws Exception the exception
   */
  @Override
  public Bean05 parseOnXml(XMLParser xmlParser, int currentEventType) throws Exception {
    Bean05 instance = new Bean05();
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
                case "beanType":
                  // property beanType (mapped on "beanType")
                  instance.setBeanType(BeanType.valueOf(StringEscapeUtils.unescapeXml(xmlParser.getElementText())));
                break;
                case "content":
                  // property content (mapped on "content")
                  instance.setContent(xmlParser.getElementAsBinary());
                break;
                case "creationTime":
                  // property creationTime (mapped on "creationTime")
                  instance.setCreationTime(DateUtils.read(StringEscapeUtils.unescapeXml(xmlParser.getElementText())));
                break;
                case "number":
                  // property number (mapped on "number")
                  instance.setNumber(PrimitiveUtils.readLong(xmlParser.getElementAsLong(), 0L));
                break;
                case "pk":
                  // property pk (mapped on "pk")
                  instance.setPk(PrimitiveUtils.readLong(xmlParser.getElementAsLong(), 0L));
                break;
                case "text":
                  // property text (mapped on "text")
                  instance.setText(StringEscapeUtils.unescapeXml(xmlParser.getElementText()));
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
