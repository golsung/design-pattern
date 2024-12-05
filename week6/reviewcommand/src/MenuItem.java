public class MenuItem {
//    public void buttonPressed(Object o) {
//        if (o instanceof Bird) ((Bird)o).sing();
//        else if (o instanceof Tv) ((Tv)o).power();
//        else if (o instanceof FileNew) ((FileNew)o).open();
//    }

    public void buttonPressed(Command cmd) {
      cmd.execute();
    }
}

