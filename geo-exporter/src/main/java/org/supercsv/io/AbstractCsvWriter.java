/*
 * Copyright 2007 Kasper B. Graversen
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.supercsv.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.supercsv.prefs.CsvPreference;
import org.supercsv.util.Util;

/**
 * Defines the standard behaviour of a CSV writer.
 * 
 * @author Kasper B. Graversen
 * @author James Bassett
 */
public abstract class AbstractCsvWriter implements ICsvWriter {
	
	private final BufferedWriter writer;
	
	private final CsvPreference preference;
	
	// the line number being written / just written
	private int lineNumber = 0;
	
	// the row being written / just written
	private int rowNumber = 0;
	
	private final StringBuilder currentColumn = new StringBuilder();
	
	/**
	 * Constructs a new <tt>AbstractCsvWriter</tt> with the supplied writer and preferences.
	 * 
	 * @param writer
	 *            the stream to write to
	 * @param preference
	 *            the CSV preferences
	 * @throws NullPointerException
	 *             if writer or preference are null
	 */
	public AbstractCsvWriter(final Writer writer, final CsvPreference preference) {
		if( writer == null ) {
			throw new NullPointerException("writer should not be null");
		} else if( preference == null ) {
			throw new NullPointerException("preference should not be null");
		}
		
		this.writer = new BufferedWriter(writer);
		this.preference = preference;
	}
	
	/**
	 * Closes the underlying writer, flushing it first.
	 */
	public void close() throws IOException {
		writer.close();
	}
	
	/**
	 * Flushes the underlying writer.
	 */
	public void flush() throws IOException {
		writer.flush();
	}
	
	/**
	 * Make a string ready for writing by escaping various characters as specified by the CSV format. This method also
	 * updates the current lineNumber as newlines are encountered in the String to be escaped.
	 * 
	 * @param csvElement
	 *            an element of a CSV file
	 * @return an escaped version of the element ready for persisting
	 */
	protected String escapeString(final String csvElement) {
		if( csvElement.length() == 0 ) {
			return "";
		}
		
		currentColumn.delete(0, currentColumn.length()); // reusing builder object
		
		final int delimiter = preference.getDelimiterChar();
		final char quote = (char) preference.getQuoteChar();
		final char space = ' ';
		final String eolSymbols = preference.getEndOfLineSymbols();
		final boolean surroundingSpacesNeedQuotes = preference.isSurroundingSpacesNeedQuotes();
		final int lastCharIndex = csvElement.length() - 1;
		
		// elements with leading/trailing spaces require surrounding quotes if surroundingSpacesNeedQuotes is enabled
		boolean needForEscape = surroundingSpacesNeedQuotes
			&& (csvElement.charAt(0) == space || csvElement.charAt(lastCharIndex) == space);
		
		for( int i = 0; i <= lastCharIndex; i++ ) {
			
			final char c = csvElement.charAt(i);
			
			if( c == delimiter ) {
				needForEscape = true;
				currentColumn.append(c);
			} else if( c == quote ) {
				needForEscape = true;
				currentColumn.append(quote);
				currentColumn.append(quote);
			} else if( c == '\n' ) {
				needForEscape = true;
				currentColumn.append(eolSymbols);
				lineNumber++;
			} else {
				currentColumn.append(c);
			}
		}
		
		// if element contains special characters, escape the
		// whole element with surrounding quotes
		if( needForEscape ) {
			currentColumn.insert(0, quote).append(quote);
		}
		
		return currentColumn.toString();
		
	}
	
	/**
	 * In order to maintain the current row and line numbers, this method <strong>must</strong> be called at the very
	 * beginning of every write method implemented in concrete CSV writers. This will allow the correct row/line numbers
	 * to be used in any exceptions thrown before writing occurs (e.g. during CellProcessor execution), and means that
	 * {@link #getLineNumber()} and {@link #getRowNumber()} can be called after writing to return the line/row just
	 * written.
	 */
	protected void incrementRowAndLineNo() {
		lineNumber++;
		rowNumber++;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int getLineNumber() {
		return lineNumber;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int getRowNumber() {
		return rowNumber;
	}
	
	/**
	 * Writes a List of columns as a line to the CsvWriter.
	 * 
	 * @param columns
	 *            the columns to write
	 * @throws IllegalArgumentException
	 *             if columns.size == 0
	 * @throws IOException
	 *             If an I/O error occurs
	 * @throws NullPointerException
	 *             if columns is null
	 */
	protected void writeRow(final List<?> columns) throws IOException {
		writeRow(Util.objectListToStringArray(columns));
	}
	
	/**
	 * Writes one or more Object columns as a line to the CsvWriter.
	 * 
	 * @param columns
	 *            the columns to write
	 * @throws IllegalArgumentException
	 *             if columns.length == 0
	 * @throws IOException
	 *             If an I/O error occurs
	 * @throws NullPointerException
	 *             if columns is null
	 */
	protected void writeRow(final Object... columns) throws IOException {
		writeRow(Util.objectArrayToStringArray(columns));
	}
	
	/**
	 * Writes one or more String columns as a line to the CsvWriter.
	 * 
	 * @param columns
	 *            the columns to write
	 * @throws IllegalArgumentException
	 *             if columns.length == 0
	 * @throws IOException
	 *             If an I/O error occurs
	 * @throws NullPointerException
	 *             if columns is null
	 */
	protected void writeRow(final String... columns) throws IOException {
		
		if( columns == null ) {
			throw new NullPointerException(String.format("columns to write should not be null on line %d", lineNumber));
		} else if( columns.length == 0 ) {
			throw new IllegalArgumentException(String.format("columns to write should not be empty on line %d",
				lineNumber));
		}
		
		for( int i = 0; i < columns.length; i++ ) {
			
			if( i > 0 ) {
				writer.write(preference.getDelimiterChar()); // delimiter
			}
			
			if( columns[i] != null ) {
				writer.write(escapeString(columns[i])); // escaped column (a null column implies "")
			}
			
		}
		
		writer.write(preference.getEndOfLineSymbols()); // EOL
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void writeHeader(final String... header) throws IOException {
		
		// update the current row/line numbers
		incrementRowAndLineNo();
		
		writeRow(header);
	}
	
}
