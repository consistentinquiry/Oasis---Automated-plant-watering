import { configureStore, ThunkAction, Action } from '@reduxjs/toolkit';
import rootReducer from "../reducers/RootReducer";

export const store = configureStore({
// @ts-ignore
    reducer: rootReducer()
  });

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
export type AppThunk<ReturnType = void> = ThunkAction<
  ReturnType,
  RootState,
  unknown,
  Action<string>
>;
