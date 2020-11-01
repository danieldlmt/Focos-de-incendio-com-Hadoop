package brFire;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class RecordeQueimadaPorEstadoMapper
extends Mapper<LongWritable, Text, Text, IntWritable> {
	@Override
	public void map (LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String delim1 = "\\t";
		//String ano;
		int quantidade;
		//String mes;
		String estado;
		String[] line;
		
		line = value.toString().split("\\t",-1);
		//ano = line[0];
		estado = line[1];
		quantidade  = Integer.parseInt(line[3].replace(".", ""));
		
		if (quantidade>0) 
		{
			context.write(new Text(estado),  new IntWritable(quantidade));
		}
		
	}
}
