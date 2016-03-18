package ar.com.java.samples.acf;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Lists;

public class LogWithOutToString {

	private MyClassToPrint myClassToPrint;

	public LogWithOutToString() {
		myClassToPrint = new MyClassToPrint();
		this.myClassToPrint.setMyString("myString");
		this.myClassToPrint.setMyList(Lists.newArrayList(1, 2, 3));
	}

	class MyClassToPrint {

		private String myString;
		private List<Integer> myList;

		public String getMyString() {
			return myString;
		}

		public void setMyString(String myString) {
			this.myString = myString;
		}

		public List<Integer> getMyList() {
			return myList;
		}

		public void setMyList(List<Integer> myList) {
			this.myList = myList;
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}
	}

	public MyClassToPrint getMyClassToPrint() {
		return myClassToPrint;
	}

	public void setMyClassToPrint(MyClassToPrint myClassToPrint) {
		this.myClassToPrint = myClassToPrint;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public static void main(String[] args) {
		LogWithOutToString logWithOutToString = new LogWithOutToString();
		System.out.println(logWithOutToString);
	}

}
