package brFire;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class RecordeQueimadaPorAnoReducer
extends Reducer<Text, IntWritable, Text, IntWritable> {
	@Override
	public void reduce
	(Text key, Iterable<IntWritable> values, Context context)
			throws IOException,InterruptedException {
		int sumQueimadas = 0;
		for (IntWritable value : values) {
			sumQueimadas += value.get();
		}
		context.write (key, new IntWritable(sumQueimadas));		
	}
}