package com.yangfuzhao.common.seq;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 序列生成器
 *
 */
public class SequenceGenerator {
	
	private AtomicLong sequence;
	private long start;
	private long max;
	private long step;
	
	private SequenceGenerator(long start, long max, long step){
		sequence = new AtomicLong(start);
		this.max = max;
		this.start = start;
		this.step = step;
	}
	
	public static SequenceGenerator getSequenceGenerator(long start, long max){
		return new SequenceGenerator(start, max, 1);
	}
	
	public static SequenceGenerator getSequenceGenerator(long start, long max, long step){
		return new SequenceGenerator(start, max, step);
	}
	
	public long next(){
		if(sequence.get() + step > max)	sequence.set(start);
		return sequence.addAndGet(step);
	}
	
	public long next(long skip){
		if(sequence.get() + skip > max) sequence.set(start);
		return sequence.addAndGet(1+skip);
	}
	
	public long current(){
		return sequence.get();
	}
	
	public int nextInt(){
		return (int)next();
	}
	
	public int currentInt(){
		return sequence.intValue();
	}
}
