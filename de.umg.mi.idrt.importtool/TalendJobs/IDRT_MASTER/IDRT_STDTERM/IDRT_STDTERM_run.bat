%~d0
cd %~dp0
java -Xms256M -Xmx1024M -cp .;../lib/routines.jar;../lib/commons-collections-3.2.jar;../lib/log4j-1.2.15.jar;../lib/log4j-1.2.16.jar;../lib/dom4j-1.6.1.jar;../lib/postgresql-9.3-1102.jdbc4.jar;../lib/ojdbc14.jar;../lib/StatusListener29.jar;../lib/OpenCSV.jar;../lib/jaxen-1.1.1.jar;../lib/advancedPersistentLookupLib-1.0.jar;../lib/jboss-serialization.jar;../lib/thashfile.jar;../lib/talendcsv.jar;../lib/saxon9.jar;../lib/trove.jar;../lib/talend_file_enhanced_20070724.jar;../lib/xpathutil-1.0.0.jar;../lib/ojdbc6.jar;idrt_stdterm_0_1.jar;database_alter_tables_0_1.jar; i2b2transmart.idrt_stdterm_0_1.IDRT_STDTERM --context=Default %* 