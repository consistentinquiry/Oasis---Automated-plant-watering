import { configureStore, ThunkAction, Action } from '@reduxjs/toolkit';
import PlantReducers from "../reducers/PlantReducers";
import JobReducers from "../reducers/JobReducers";

export const store = configureStore({
  reducer: {
    //@ts-ignore
    plant: PlantReducers,
    //@ts-ignore
    job: JobReducers
  },
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
export type AppThunk<ReturnType = void> = ThunkAction<
  ReturnType,
  RootState,
  unknown,
  Action<string>
>;
