package java_core.block1.task1_2_worker;

@FunctionalInterface
public interface OnTaskErrorListener {
    void onError(String error);
}
