package brFire;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class RecordeQueimadaPorAnoMapper
extends Mapper<LongWritable, Text, Text, IntWritable> {
	private static final int MISSING = 9999;
	@Override
	public void map (LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		String delim1 = ",";
		String ano;
		int quantidade;
		//String mes;
		String estado;
		String[] line;
		
		line = value.toString().split("\\t",-1);
		//ano = line[0];
		ano = line[0].replace("\"", "");
		quantidade  = Integer.parseInt(line[3].replace(".", ""));
		
		if (quantidade>0) 
		{
			context.write(new Text(ano),  new IntWritable(quantidade));
		}
		
	}
}
