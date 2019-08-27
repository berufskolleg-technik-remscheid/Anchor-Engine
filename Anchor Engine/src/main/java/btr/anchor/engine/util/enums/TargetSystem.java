package btr.anchor.engine.util.enums;

import btr.anchor.engine.pidl.IndependenceLayerType;

public enum TargetSystem {

    ANDROID(IndependenceLayerType.ANDROID), PC(IndependenceLayerType.AWT);

    TargetSystem(IndependenceLayerType independenceLayerType) {
        this.independenceLayerType = independenceLayerType;
    }

    public IndependenceLayerType independenceLayerType;
}
