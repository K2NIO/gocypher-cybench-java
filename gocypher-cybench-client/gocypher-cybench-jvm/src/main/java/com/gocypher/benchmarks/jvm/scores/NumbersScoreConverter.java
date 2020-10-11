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

package com.gocypher.benchmarks.jvm.scores;

import com.gocypher.benchmarks.core.model.BaseScoreConverter;

import java.util.Map;

public class NumbersScoreConverter extends BaseScoreConverter {

    @Override
    public Double convertScore(Double score, Map<String,Object> metaData) {
        if (score != null){
            /*Double oldScore = new Double((double)score.doubleValue()/1000) ;
            Double newScore = (StringBenchmarks.numberOfIterations/oldScore) ;
            */
            Double newScore = score/10_000 ;
            return newScore ;
        }
        return null ;
    }

    @Override
    public String getUnits() {
        return "10k ops/s";
    }
}