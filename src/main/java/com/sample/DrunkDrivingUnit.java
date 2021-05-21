package com.sample;

import com.sample.model.DrunkDriving;

import org.kie.kogito.rules.DataSource;
import org.kie.kogito.rules.DataStore;
import org.kie.kogito.rules.RuleUnitData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrunkDrivingUnit implements RuleUnitData {

    private DataStore<DrunkDriving> drunkDrivings = DataSource.createStore();
    
}
