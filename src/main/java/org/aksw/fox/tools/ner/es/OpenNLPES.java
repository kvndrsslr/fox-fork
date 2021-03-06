package org.aksw.fox.tools.ner.es;

import org.aksw.fox.tools.ner.common.OpenNLPCommon;

public class OpenNLPES extends OpenNLPCommon {

  static final String[] modelPath = {"data/openNLP/es-ner-person.bin",
      "data/openNLP/es-ner-location.bin", "data/openNLP/es-ner-organization.bin"};

  public OpenNLPES() {
    super(modelPath);
  }
}
