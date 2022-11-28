import {GET_PLANT} from "../actions/PlantActions";
import {Action} from "../utils/ActionTypeUtils";


const defaultState = {plants: {}};

export default function PlantReducers (state = defaultState, action: Action<string>) {
    switch(action.type){
        case GET_PLANT:
            return {
                ...state,
                plants: action.payload,
            }
        default:
            return state;
    }
}
