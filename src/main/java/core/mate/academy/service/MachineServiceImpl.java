package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl implements MachineService<Machine> {
    private Bulldozer bulldozer = new Bulldozer();
    private Excavator excavator = new Excavator();
    private Truck truck = new Truck();

    public MachineServiceImpl() {
    }

    @Override
    public List<? extends Machine> getAll(Class type) {
        List<? extends Machine> resultList = new ArrayList<>();
        if (type == Bulldozer.class) {
            resultList = bulldozer.get();
        }
        if (type == Excavator.class) {
            resultList = excavator.get();
        }
        if (type == Truck.class) {
            resultList = truck.get();
        }
        if (type == Bulldozer.class
                && type == Excavator.class
                && type == Truck.class) {
            resultList = new ArrayList<>();
        }
        return resultList;
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    public void startWorking(List<? extends Machine> machines) {
        for (Machine machine : machines) {
            if (machine instanceof Bulldozer) {
                bulldozer.doWork();
            }
            if (machine instanceof Excavator) {
                excavator.doWork();
            }
            if (machine instanceof Truck) {
                truck.doWork();
            }
        }
    }
}
