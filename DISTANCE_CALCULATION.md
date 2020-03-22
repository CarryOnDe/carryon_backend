#### Using postgis a calculation of distance and request within a certain distance can be achieved using the following snippets

###### Create the table with a geometry column

    CREATE TABLE carryon."HELP_REQUEST"
    (
        "ID" bigint NOT NULL,
        "TITLE" character varying(200) COLLATE pg_catalog."default",
        "GEOM" geometry(Point,4326),
        CONSTRAINT "HELP_REQUEST_pkey" PRIMARY KEY ("ID")
    )
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;
    
    ALTER TABLE carryon."HELP_REQUEST"
        OWNER to postgres;

###### Example for inserting values with geographic reference

    INSERT INTO carryon."HELP_REQUEST"(
	    "ID", "TITLE", "GEOM")
	    VALUES (1, 'Test', ST_GeomFromText('POINT(-71.060316 48.432044)', 4326));
	
    INSERT INTO carryon."HELP_REQUEST"(
    	"ID", "TITLE", "GEOM")
    	VALUES (2, 'Test 2', ST_GeomFromText('POINT(-71.060306 48.432041)', 4326));

###### This selects all the requests within 1000 meters around the given point

    SELECT *  
    FROM carryon."HELP_REQUEST"  
    WHERE ST_DWithin("GEOM", ST_MakePoint(-71.060312, 48.432044)::geography, 1000);

###### This selects all the requests within 1000 meters around the given point ordered by distance

    SELECT "ID", "TITLE", ST_Distance("GEOM", ref_geom) AS distance  
    FROM carryon."HELP_REQUEST"    
    CROSS JOIN (SELECT ST_MakePoint(-71.050312, 48.432044)::geography AS ref_geom) AS r  
    WHERE ST_DWithin("GEOM", ref_geom, 1000)  
    ORDER BY ST_Distance("GEOM", ref_geom);     
