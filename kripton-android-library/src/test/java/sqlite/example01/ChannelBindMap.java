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
package sqlite.example01;

import com.abubusoft.kripton.AbstractMapper;
import com.abubusoft.kripton.annotation.BindMap;
import com.abubusoft.kripton.common.PrimitiveUtils;
import com.abubusoft.kripton.escape.StringEscapeUtils;
import com.abubusoft.kripton.xml.XMLParser;
import com.abubusoft.kripton.xml.XMLSerializer;
import com.abubusoft.kripton.xml.XmlPullParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

// TODO: Auto-generated Javadoc
/**
 * This class is binder map for Channel.
 *
 * @see Channel
 */
@BindMap(Channel.class)
public class ChannelBindMap extends AbstractMapper<Channel> {
  
  /* (non-Javadoc)
   * @see com.abubusoft.kripton.BinderMapper#serializeOnJackson(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator)
   */
  @Override
  public int serializeOnJackson(Channel object, JsonGenerator jacksonSerializer) throws Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field id (mapped with "id")
    fieldCount++;
    jacksonSerializer.writeNumberField("id", object.getId());

    // field name (mapped with "name")
    if (object.getName()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("name", object.getName());
    }

    // field ownerUid (mapped with "ownerUid")
    if (object.getOwnerUid()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("ownerUid", object.getOwnerUid());
    }

    // field uid (mapped with "uid")
    if (object.getUid()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("uid", object.getUid());
    }

    // field updateTime (mapped with "updateTime")
    fieldCount++;
    jacksonSerializer.writeNumberField("updateTime", object.getUpdateTime());

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  /* (non-Javadoc)
   * @see com.abubusoft.kripton.BinderMapper#serializeOnJacksonAsString(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator)
   */
  @Override
  public int serializeOnJacksonAsString(Channel object, JsonGenerator jacksonSerializer) throws
      Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field id (mapped with "id")
    jacksonSerializer.writeStringField("id", PrimitiveUtils.writeLong(object.getId()));

    // field name (mapped with "name")
    if (object.getName()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("name", object.getName());
    }

    // field ownerUid (mapped with "ownerUid")
    if (object.getOwnerUid()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("ownerUid", object.getOwnerUid());
    }

    // field uid (mapped with "uid")
    if (object.getUid()!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("uid", object.getUid());
    }

    // field updateTime (mapped with "updateTime")
    jacksonSerializer.writeStringField("updateTime", PrimitiveUtils.writeLong(object.getUpdateTime()));

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
  public void serializeOnXml(Channel object, XMLSerializer xmlSerializer, int currentEventType)
      throws Exception {
    if (currentEventType == 0) {
      xmlSerializer.writeStartElement("channel");
    }

    // Persisted fields:

    // field id (mapped with "id")
    xmlSerializer.writeStartElement("id");
    xmlSerializer.writeLong(object.getId());
    xmlSerializer.writeEndElement();

    // field name (mapped with "name")
    if (object.getName()!=null) {
      xmlSerializer.writeStartElement("name");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(object.getName()));
      xmlSerializer.writeEndElement();
    }

    // field ownerUid (mapped with "ownerUid")
    if (object.getOwnerUid()!=null) {
      xmlSerializer.writeStartElement("ownerUid");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(object.getOwnerUid()));
      xmlSerializer.writeEndElement();
    }

    // field uid (mapped with "uid")
    if (object.getUid()!=null) {
      xmlSerializer.writeStartElement("uid");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(object.getUid()));
      xmlSerializer.writeEndElement();
    }

    // field updateTime (mapped with "updateTime")
    xmlSerializer.writeStartElement("updateTime");
    xmlSerializer.writeLong(object.getUpdateTime());
    xmlSerializer.writeEndElement();

    if (currentEventType == 0) {
      xmlSerializer.writeEndElement();
    }
  }

  /**
   * parse with jackson.
   *
   * @param jacksonParser the jackson parser
   * @return the channel
   * @throws Exception the exception
   */
  @Override
  public Channel parseOnJackson(JsonParser jacksonParser) throws Exception {
    Channel instance = new Channel();
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
            instance.setId(jacksonParser.getLongValue());
          break;
          case "name":
            // field name (mapped with "name")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setName(jacksonParser.getText());
            }
          break;
          case "ownerUid":
            // field ownerUid (mapped with "ownerUid")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setOwnerUid(jacksonParser.getText());
            }
          break;
          case "uid":
            // field uid (mapped with "uid")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setUid(jacksonParser.getText());
            }
          break;
          case "updateTime":
            // field updateTime (mapped with "updateTime")
            instance.setUpdateTime(jacksonParser.getLongValue());
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
   * @return the channel
   * @throws Exception the exception
   */
  @Override
  public Channel parseOnJacksonAsString(JsonParser jacksonParser) throws Exception {
    Channel instance = new Channel();
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
            instance.setId(PrimitiveUtils.readLong(jacksonParser.getText(), 0L));
          break;
          case "name":
            // field name (mapped with "name")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setName(jacksonParser.getText());
            }
          break;
          case "ownerUid":
            // field ownerUid (mapped with "ownerUid")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setOwnerUid(jacksonParser.getText());
            }
          break;
          case "uid":
            // field uid (mapped with "uid")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.setUid(jacksonParser.getText());
            }
          break;
          case "updateTime":
            // field updateTime (mapped with "updateTime")
            instance.setUpdateTime(PrimitiveUtils.readLong(jacksonParser.getText(), 0L));
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
   * @return the channel
   * @throws Exception the exception
   */
  @Override
  public Channel parseOnXml(XMLParser xmlParser, int currentEventType) throws Exception {
    Channel instance = new Channel();
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
                  instance.setId(PrimitiveUtils.readLong(xmlParser.getElementAsLong(), 0L));
                break;
                case "name":
                  // property name (mapped on "name")
                  instance.setName(StringEscapeUtils.unescapeXml(xmlParser.getElementText()));
                break;
                case "ownerUid":
                  // property ownerUid (mapped on "ownerUid")
                  instance.setOwnerUid(StringEscapeUtils.unescapeXml(xmlParser.getElementText()));
                break;
                case "uid":
                  // property uid (mapped on "uid")
                  instance.setUid(StringEscapeUtils.unescapeXml(xmlParser.getElementText()));
                break;
                case "updateTime":
                  // property updateTime (mapped on "updateTime")
                  instance.setUpdateTime(PrimitiveUtils.readLong(xmlParser.getElementAsLong(), 0L));
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
