package lesson1;

public interface Actionable {

    boolean isAction();

    String getNAME();

    int getMAX_JUMP();

    int getMAX_RUN();

    void setAction(boolean action);
}
