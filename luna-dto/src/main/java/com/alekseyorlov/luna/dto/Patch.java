package com.alekseyorlov.luna.dto;

import com.alekseyorlov.luna.dto.patch.Operation;

import java.util.List;

public class Patch {

    private List<Operation> operations;

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
