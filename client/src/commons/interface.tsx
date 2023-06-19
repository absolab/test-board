export const ResponseResultValue = {
    SUCCESS: 'SUCCESS',
    FAIL: 'FAIL',
}

export interface BoardInterface {
    bid?: number | string,
    title?: string,
    content?: string,
    name?: string,
    crtnDate?: string,
    mdfdDate?: string,
}

export interface ResponseInterface {
    result: string,
    msg: string,
    data: Object,
}

export interface LoginResponseInterface extends ResponseInterface {
    data: {
        id: string,
        name: string,
        reg_date: string,
    }
}

export interface BoardListResponseInterface extends ResponseInterface {
    data: Array<BoardInterface>
}

export interface BoardDetailResponseInterface extends ResponseInterface {
    data: BoardInterface
}

export interface PageCountResponseInterface extends ResponseInterface {
    data: number;
}