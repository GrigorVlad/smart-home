package ru.sbt.mipt.oop.remotecontrol.ordinarycommands;

import ru.sbt.mipt.oop.components.Light;
import ru.sbt.mipt.oop.components.Room;
import ru.sbt.mipt.oop.components.SmartHome;
import ru.sbt.mipt.oop.remotecontrol.SaverSmartHomeState;

public class TurnOnAllLightCommand implements Command {

    SmartHome smartHome;
    SaverSmartHomeState saver;

    public TurnOnAllLightCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
        saver = new SaverSmartHomeState();
    }

    @Override
    public void undoCommand() {
        smartHome.setState(saver.returnState());
    }

    @Override
    public void doCommand() {

        saver.saveState(smartHome);
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                light.setState(true);
            }
        }

    }

}
