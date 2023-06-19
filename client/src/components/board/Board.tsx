import { BoardInterface } from "commons/interface";
import { ChangeEvent } from "react";

const Board:React.FC<{data:BoardInterface, readOnly:boolean}> = ({data, readOnly}) => {

    function onTitleChangeEvent(e: ChangeEvent<HTMLInputElement>) { data.title = e.target.value; }
    function onContentChangeEvent(e: ChangeEvent<HTMLTextAreaElement>) { data.content = e.target.value; }

    return (
        <div className="flex flex-col mx-auto">
            <input className="border-[2px] border-lime-400 w-[800px] outline-none p-2 mb-2" placeholder="제목" readOnly={readOnly} value={data.title} onChange={onTitleChangeEvent}/>
            <div className="flex text-gray-500 text-sm">
                <div className="mr-2">{data.name}</div>|<div className="ml-2">{data.crtnDate}</div>
            </div>
            <textarea className="border-[2px] border-lime-400 w-[800px] outline-none p-2 mt-3 resize-none h-96" placeholder="내용" readOnly={readOnly} value={data.content} onChange={onContentChangeEvent}/>
        </div>
    )
}

export default Board;
