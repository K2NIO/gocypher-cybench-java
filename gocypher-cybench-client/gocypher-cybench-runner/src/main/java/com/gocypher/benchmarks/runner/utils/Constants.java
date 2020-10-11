/*
 * Copyright (C) 2020, K2N.IO.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 */

package com.gocypher.benchmarks.runner.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	public static final String SHOULD_SEND_REPORT = "sendReport";
	public static final String URL_LINK_TO_GOCYPHER_REPORT = "reportUrl";
	public static final String BENCHMARK_REPORT_NAME = "reportName";
	public static final String BENCHMARK_RUN_CLASSES = "benchmarkClasses";

//--------------------------- Properties that configure the runner execution ------------------------------------------
	public static final String NUMBER_OF_FORKS = "numberOfBenchmarkForks";
	public static final String MEASUREMENT_ITERATIONS = "measurementIterations";
	public static final String WARM_UP_ITERATIONS = "warmUpIterations";
	public static final String WARM_UP_SECONDS = "warmUpSeconds";
	public static final String BENCHMARK_RUN_THREAD_COUNT = "runThreadCount";

	public static final String REPORT_UPLOAD_STATUS = "reportUploadStatus";
	public static final String CUSTOM_BENCHMARK_METADATA = "customBenchmarkMetadata";


	public static final Map<String,String> BENCHMARKS_SCORES_COMPUTATIONS_MAPPING = new HashMap<>() ;
	static {

//---------------------------Score converters for sync file seek access------------------------------------------
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOAsyncFileSeekBenchmarks.seekAndReadFileUsingSmallChunks","com.gocypher.benchmarks.jvm.scores.IOSeekScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOAsyncFileSeekBenchmarks.seekAndReadFileUsingHugeChunks","com.gocypher.benchmarks.jvm.scores.IOSeekScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOAsyncFileSeekBenchmarks.seekAndWriteFileUsingSmallChunks","com.gocypher.benchmarks.jvm.scores.IOSeekScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOAsyncFileSeekBenchmarks.seekAndWriteFileUsingHugeChunks","com.gocypher.benchmarks.jvm.scores.IOSeekScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOAsyncFileSeekBenchmarks.seekAndCopyFileUsingSmallChunks","com.gocypher.benchmarks.jvm.scores.IOSeekScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOAsyncFileSeekBenchmarks.seekAndCopyFileUsingHugeChunks","com.gocypher.benchmarks.jvm.scores.IOSeekScoreConverter") ;

//---------------------------Score converters for sync file seek access------------------------------------------

		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOSyncFileSeekBenchmarks.seekAndReadFileUsingSmallChunks","com.gocypher.benchmarks.jvm.scores.IOSyncSeekScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOSyncFileSeekBenchmarks.seekAndReadFileUsingHugeChunks","com.gocypher.benchmarks.jvm.scores.IOSyncSeekScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOSyncFileSeekBenchmarks.seekAndWriteFileUsingSmallChunks","com.gocypher.benchmarks.jvm.scores.IOSyncSeekScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOSyncFileSeekBenchmarks.seekAndWriteFileUsingHugeChunks","com.gocypher.benchmarks.jvm.scores.IOSyncSeekScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOSyncFileSeekBenchmarks.seekAndCopyFileUsingSmallChunks","com.gocypher.benchmarks.jvm.scores.IOSyncSeekScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOSyncFileSeekBenchmarks.seekAndCopyFileUsingHugeChunks","com.gocypher.benchmarks.jvm.scores.IOSyncSeekScoreConverter") ;

//----------------------Score converter for async file copy benchmarks----------------------------------------------
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOAsyncAPIComparisonBenchmarks.copyFileUsingMappedByteBuffer","com.gocypher.benchmarks.jvm.scores.IOReadWriteScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOAsyncAPIComparisonBenchmarks.copyFileUsingFileStreamAndSmallChunks","com.gocypher.benchmarks.jvm.scores.IOReadWriteScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOAsyncAPIComparisonBenchmarks.copyFileUsingFileStreamAndHugeChunks","com.gocypher.benchmarks.jvm.scores.IOReadWriteScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOAsyncAPIComparisonBenchmarks.copyFileUsingBufferedStreamAndSmallChunks","com.gocypher.benchmarks.jvm.scores.IOReadWriteScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOAsyncAPIComparisonBenchmarks.copyFileUsingBufferedStreamAndHugeChunks","com.gocypher.benchmarks.jvm.scores.IOReadWriteScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOAsyncAPIComparisonBenchmarks.copyFileUsingDirectBufferedStreamAndSmallChunks","com.gocypher.benchmarks.jvm.scores.IOReadWriteScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOAsyncAPIComparisonBenchmarks.copyFileUsingDirectBufferedStreamAndHugeChunks","com.gocypher.benchmarks.jvm.scores.IOReadWriteScoreConverter") ;

//----------------------Score converter for sync file copy benchmarks----------------------------------------------

		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOSyncAPIComparisonBenchmarks.copyFileUsingMappedByteBuffer","com.gocypher.benchmarks.jvm.scores.IOSyncReadWriteScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOSyncAPIComparisonBenchmarks.copyFileUsingFileStreamAndSmallChunks","com.gocypher.benchmarks.jvm.scores.IOSyncReadWriteScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOSyncAPIComparisonBenchmarks.copyFileUsingFileStreamAndHugeChunks","com.gocypher.benchmarks.jvm.scores.IOSyncReadWriteScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOSyncAPIComparisonBenchmarks.copyFileUsingBufferedStreamAndSmallChunks","com.gocypher.benchmarks.jvm.scores.IOSyncReadWriteScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOSyncAPIComparisonBenchmarks.copyFileUsingBufferedStreamAndHugeChunks","com.gocypher.benchmarks.jvm.scores.IOSyncReadWriteScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOSyncAPIComparisonBenchmarks.copyFileUsingDirectBufferedStreamAndSmallChunks","com.gocypher.benchmarks.jvm.scores.IOSyncReadWriteScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.IOSyncAPIComparisonBenchmarks.copyFileUsingDirectBufferedStreamAndHugeChunks","com.gocypher.benchmarks.jvm.scores.IOSyncReadWriteScoreConverter") ;
//---------------------Score converter for String operations--------------------------------------------------------------

		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.StringBenchmarks.stringConcatMultiChars","com.gocypher.benchmarks.jvm.scores.StringBufferScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.StringBenchmarks.stringBufferConcatMultiChars","com.gocypher.benchmarks.jvm.scores.StringBufferScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.StringBenchmarks.stringReplaceAll","com.gocypher.benchmarks.jvm.scores.StringBufferScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.StringBenchmarks.stringBufferReplaceAll","com.gocypher.benchmarks.jvm.scores.StringBufferScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.StringBenchmarks.findRegexCompiled","com.gocypher.benchmarks.jvm.scores.StringBufferScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.StringBenchmarks.findRegexUnCompiled","com.gocypher.benchmarks.jvm.scores.StringBufferScoreConverter") ;

//---------------------Score converter for Number operations--------------------------------------------------------------
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.NumberBenchmarks.generateAndAddDoubleNumbers","com.gocypher.benchmarks.jvm.scores.NumbersScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.NumberBenchmarks.generateAndAddAtomicNumbers","com.gocypher.benchmarks.jvm.scores.NumbersScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.NumberBenchmarks.generateAndAddBigDecimalNumbers","com.gocypher.benchmarks.jvm.scores.NumbersScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.NumberBenchmarks.generateAndLogarithmDoubleNumbers","com.gocypher.benchmarks.jvm.scores.NumbersScoreConverter") ;
		BENCHMARKS_SCORES_COMPUTATIONS_MAPPING.put("com.gocypher.benchmarks.jvm.client.tests.NumberBenchmarks.generateAndPowerDoubleNumbers","com.gocypher.benchmarks.jvm.scores.NumbersScoreConverter") ;
	}

}