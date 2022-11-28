import {combineReducers} from "redux";
import PlantReducers from "./PlantReducers";
import JobReducers from "./JobReducers";

const rootReducer = combineReducers({
        plants: PlantReducers,
        jobs: JobReducers
    });

export default rootReducer;