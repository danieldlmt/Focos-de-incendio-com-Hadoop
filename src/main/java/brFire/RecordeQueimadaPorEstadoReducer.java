package brFire;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class RecordeQueimadaPorEstadoReducer
extends Reducer<Text, IntWritable, Text, IntWritable> {
	@Override
	public void reduce
	(Text key, Iterable<IntWritable> values, Context context)
			throws IOException,InterruptedException {
		int recordeMensalQueimada = Integer.MIN_VALUE;
		for (IntWritable value : values) {
			recordeMensalQueimada = Math.max(recordeMensalQueimada, value.get());
		}
		context.write (key, new IntWritable(recordeMensalQueimada));
	}
}