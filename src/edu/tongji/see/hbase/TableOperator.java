package edu.tongji.see.hbase;

import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.conf.Configuration;
import java.io.IOException;
 
public class TableOperator
{
    public static void createHBaseTable(String tablename, String familyname)     throws IOException
    {
        Configuration config = HBaseConfiguration.create();
        config.addResource(new Path("/usr/local/hbase-0.94.1/conf/hbase-site.xml"));
        HBaseAdmin admin = new HBaseAdmin(config);
        HTableDescriptor htd = new HTableDescriptor(tablename);
        HColumnDescriptor col = new HColumnDescriptor(familyname);
        htd.addFamily(col);
        if(admin.tableExists(tablename))
        {
            return;
        }
        admin.createTable(htd);
    }
    public static void main(String[] args)
    {
        try
        {
            createHBaseTable("t2", "ff");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

