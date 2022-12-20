import PlantReducers from "./PlantReducers";
import JobReducers from "./JobReducers";

export const rootReducer = () => ({
    jobs: JobReducers,
    plants: PlantReducers
})

export default rootReducer;