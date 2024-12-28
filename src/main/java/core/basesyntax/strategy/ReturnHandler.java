package core.basesyntax.strategy;

import static core.basesyntax.storage.FruitStorage.fruitStorage;

import core.basesyntax.storage.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        if (transaction.getQuantity() <= 0) {
            throw new IllegalArgumentException("Return cannot be less than or equal to 0");
        }
        fruitStorage.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
