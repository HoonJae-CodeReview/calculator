package output;

import repository.Repository;

public interface Output {
    public Repository repository = new Repository();
    public void printOperationResult();
}
