package com.syncfusion;

import java.io.IOException;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class CupCount extends Configured implements Tool {

	public static class Map extends Mapper<LongWritable, Text, Text, DoubleWritable> {

		private Text beverageName = new Text();

		public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();

			if (line == null || line.length() == 0)
				return;

			String[] tokens = line.split(",", -1);
			beverageName.set(tokens[1]);
			int count = Integer.parseInt(tokens[2].trim());
			context.write(beverageName, new DoubleWritable(count));
		}
	}

	public static class Reduce extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {

		public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
				throws IOException, InterruptedException {
			double sum = 0;
			int count = 0;
			for (DoubleWritable val : values) {
				sum += val.get();
				count += 1;
			}

			context.write(key, new DoubleWritable(sum / count));
		}
	}

	public int run(String[] args) throws Exception {

		Job job = Job.getInstance(this.getConf());

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);

		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.setJarByClass(CupCount.class);

		job.submit();
		return 0;
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
		ToolRunner.run(new CupCount(), otherArgs);
	}
}