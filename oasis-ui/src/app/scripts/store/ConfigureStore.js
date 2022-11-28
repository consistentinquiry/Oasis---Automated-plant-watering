import {applyMiddleware, compose} from 'redux'
import thunkMiddleware from 'redux-thunk'
import logger from "../middleware/Logger";
import monitorReducer from "../enhancers/MonitorReducer";
import RootReducer from "../reducers/RootReducer";


export default function configureStore() {

    const createStoreWithMiddleware = () => {
        const middlewares = [logger, thunkMiddleware, ]
        const middlewareEnhancer = applyMiddleware(...middlewares)

        const enhancers = [middlewareEnhancer, monitorReducer]
        return compose(
            ...enhancers,
            window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
        );
    }

    return configureStore(RootReducer, createStoreWithMiddleware())
}