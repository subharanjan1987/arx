/*
 * ARX: Powerful Data Anonymization
 * Copyright 2012 - 2015 Florian Kohlmayer, Fabian Prasser
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.deidentifier.arx.test;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.math3.analysis.function.Log;
import org.deidentifier.arx.ARXConfiguration;
import org.deidentifier.arx.DataGeneralizationScheme;
import org.deidentifier.arx.DataGeneralizationScheme.GeneralizationDegree;
import org.deidentifier.arx.criteria.EDDifferentialPrivacy;
import org.deidentifier.arx.metric.Metric;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Test for data transformations.
 *
 * @author Fabian Prasser
 * @author Florian Kohlmayer
 */
@RunWith(Parameterized.class)
public class TestAnonymizationDifferentialPrivacy extends AbstractAnonymizationTest {
    
    /** Constant*/
    private static final double LN3 = new Log().value(3);
    /** Constant*/
    private static final double LN2 = new Log().value(2);
    
    /**
     * Create tests
     * @return
     */
    @Parameters(name = "{index}:[{0}]")
    public static Collection<Object[]> cases() {
        return Arrays.asList(new Object[][] {
                                              /* 0 */{ new ARXAnonymizationTestCase(ARXConfiguration.create(1d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(2d, 1E-5d, DataGeneralizationScheme.create(GeneralizationDegree.LOW_MEDIUM), true)), "../arx-data/data-junit/adult.csv", 0.6820705793543056, new int[] { 0, 2, 0, 1, 1, 1, 1, 1, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(1d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(1.5d, 1E-6d, DataGeneralizationScheme.create(GeneralizationDegree.HIGH), true)), "../arx-data/data-junit/adult.csv", 0.8112222411559193, new int[] { 1, 3, 1, 2, 2, 2, 2, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(LN2, 1E-7d, DataGeneralizationScheme.create(GeneralizationDegree.LOW_MEDIUM), true)), "../arx-data/data-junit/adult.csv", 0.7437618217405468, new int[] { 0, 2, 0, 1, 1, 1, 1, 1, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(LN3, 1E-8d, DataGeneralizationScheme.create(GeneralizationDegree.MEDIUM), true)), "../arx-data/data-junit/adult.csv", 0.6092780386290699, new int[] { 1, 2, 1, 1, 2, 1, 1, 1, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(1d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(2d, 1E-5d, DataGeneralizationScheme.create(GeneralizationDegree.MEDIUM_HIGH), true)), "../arx-data/data-junit/adult.csv", 0.5968589299712612, new int[] { 1, 2, 1, 1, 2, 1, 1, 1, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(1d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(1.5d, 1E-6d, DataGeneralizationScheme.create(GeneralizationDegree.LOW_MEDIUM), true)), "../arx-data/data-junit/adult.csv", 0.6856395441402736, new int[] { 0, 2, 0, 1, 1, 1, 1, 1, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(LN2, 1E-7d, DataGeneralizationScheme.create(GeneralizationDegree.MEDIUM_HIGH), true)), "../arx-data/data-junit/cup.csv", 0.8261910998091719, new int[] { 3, 2, 1, 1, 1, 2, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(1.0d, 1E-8d, DataGeneralizationScheme.create(GeneralizationDegree.MEDIUM), true)), "../arx-data/data-junit/cup.csv", 0.8499906952842589, new int[] { 3, 2, 1, 1, 1, 2, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(1d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(2d, 1E-5d, DataGeneralizationScheme.create(GeneralizationDegree.LOW_MEDIUM), true)), "../arx-data/data-junit/cup.csv", 1.0000000000000004, new int[] { 2, 2, 0, 1, 0, 2, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(1.5d, 1E-6d, DataGeneralizationScheme.create(GeneralizationDegree.MEDIUM_HIGH), true)), "../arx-data/data-junit/cup.csv", 0.7606582708058056, new int[] { 3, 2, 1, 1, 1, 2, 2, 2 }, false) },
                                              /* 10 */{ new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(2d, 1E-7d, DataGeneralizationScheme.create(GeneralizationDegree.LOW_MEDIUM), true)), "../arx-data/data-junit/cup.csv", 1.0000000000000004, new int[] { 2, 2, 0, 1, 0, 2, 2, 2 }, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(1d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(LN3, 1E-8d, DataGeneralizationScheme.create(GeneralizationDegree.MEDIUM), true)), "../arx-data/data-junit/cup.csv", 0.839519540778112, new int[] { 3, 2, 1, 1, 1, 2, 2, 2 }, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(2d, 1E-5d, DataGeneralizationScheme.create(GeneralizationDegree.LOW_MEDIUM), true)), "../arx-data/data-junit/fars.csv", 0.5814200080206713, new int[] { 2, 1, 1, 1, 0, 1, 1, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(1d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(LN2, 1E-6d, DataGeneralizationScheme.create(GeneralizationDegree.HIGH), true)), "../arx-data/data-junit/fars.csv", 0.6800577425519756, new int[] { 4, 2, 2, 2, 1, 2, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(1.0d, 1E-7d, DataGeneralizationScheme.create(GeneralizationDegree.LOW_MEDIUM), true)), "../arx-data/data-junit/fars.csv", 0.5864014933190864, new int[] { 2, 1, 1, 1, 0, 1, 1, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(1.5d, 1E-8d, DataGeneralizationScheme.create(GeneralizationDegree.MEDIUM), true)), "../arx-data/data-junit/fars.csv", 0.43090885593016726, new int[] { 3, 1, 2, 2, 1, 1, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(1d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(LN3, 1E-5d, DataGeneralizationScheme.create(GeneralizationDegree.HIGH), true)), "../arx-data/data-junit/fars.csv", 0.6796862034370221, new int[] { 4, 2, 2, 2, 1, 2, 2, 2 }, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createLossMetric()).addCriterion(new EDDifferentialPrivacy(1.0d, 1E-6d, DataGeneralizationScheme.create(GeneralizationDegree.MEDIUM_HIGH), true)), "../arx-data/data-junit/fars.csv", 0.40463191801066123, new int[] { 3, 1, 2, 2, 1, 1, 2, 1 }, false) },
        });
    }
    
    /**
     * 
     *
     * @param testCase
     */
    public TestAnonymizationDifferentialPrivacy(final ARXAnonymizationTestCase testCase) {
        super(testCase);
    }
    
}
