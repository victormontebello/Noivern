package com.montebello.noivern.UseCases;

import com.montebello.noivern.core.Interface.IAlgorithm;
import com.montebello.noivern.core.models.Algorithm;

public class UseCasesBus {
    public static Algorithm getUseCaseBus(IAlgorithm iAlgorithm) {
        return iAlgorithm.getAlgorithm();
    }
}
