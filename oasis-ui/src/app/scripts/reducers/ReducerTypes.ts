
export interface IPlantAction {
    type: string,
    payload: object
}

export interface IJobAction {
    type: string,
    payload: object
}

export type TAction = IPlantAction | IJobAction;