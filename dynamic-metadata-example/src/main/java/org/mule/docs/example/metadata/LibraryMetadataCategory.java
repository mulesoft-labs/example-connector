package org.mule.docs.example.metadata;

import org.mule.api.annotations.MetaDataKeyRetriever;
import org.mule.api.annotations.MetaDataRetriever;
import org.mule.api.annotations.components.MetaDataCategory;
import org.mule.common.metadata.*;
import org.mule.common.metadata.builder.DefaultMetaDataBuilder;
import org.mule.common.metadata.datatype.DataType;
import org.mule.docs.example.ExampleDynamicMetadataConnector;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mulesoft, Inc
 */
@MetaDataCategory
public class LibraryMetadataCategory {

    @Inject
    ExampleDynamicMetadataConnector connector;

    public void setConnector(ExampleDynamicMetadataConnector connector) {
        this.connector = connector;
    }

    @MetaDataKeyRetriever
    public List<MetaDataKey> getEntities() throws Exception {

        List<MetaDataKey> entities = new ArrayList<MetaDataKey>();

        entities.add(new DefaultMetaDataKey("Book_id","Book"));
        entities.add(new DefaultMetaDataKey("Author_id","Author"));
        entities.add(new DefaultMetaDataKey("BookList_id","BookList"));

        return entities;
    }

    @MetaDataRetriever
    public MetaData describeEntity(MetaDataKey entityKey) throws Exception {

        //Here we describe the entity depending on the entity key
        if ("Author_id".equals(entityKey.getId())) {
            MetaDataModel authorModel =  new DefaultMetaDataBuilder().createDynamicObject("Author")
                    .addSimpleField("firstName", DataType.STRING)
                    .addSimpleField("lastName", DataType.STRING)
                    .build();
            return new DefaultMetaData(authorModel);
        }

        if ("Book_id".equals(entityKey.getId())) {
            MetaDataModel bookModel =  new   DefaultMetaDataBuilder().createDynamicObject("Book")
                    .addSimpleField("title",DataType.STRING)
                    .addSimpleField("synopsis",DataType.STRING)
                    .addDynamicObjectField("author")
                    .addSimpleField("firstName",DataType.STRING)
                    .addSimpleField("lastName",DataType.STRING)
                    .endDynamicObject()
                    .build();
            return new DefaultMetaData(bookModel);
        }

        if ("BookList_id".equals(entityKey.getId())) {
            MetaDataModel bookListModel =  new DefaultMetaDataBuilder().createList().ofDynamicObject("book").build();
            return new DefaultMetaData(bookListModel);
        }

        throw new RuntimeException(String.format("This entity %s is not supported",entityKey.getId()));

    }

}
