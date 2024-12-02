package main.java.use_case.gettoolbought;

public interface GetToolBoughtOutputBoundary {

    /**
     * executes code for gettoolbought use case
     * @param bought, if the tool has been bought or not
     */
    void toolBought(String tool, boolean bought, int level);
}
