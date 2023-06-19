import { BoardInterface } from "commons/interface";
import { ChangeEvent } from "react";

const Board:React.FC<{data:BoardInterface, readOnly:boolean}> = ({data, readOnly}) => {

    function onTitleChangeEvent(e: ChangeEvent<HTMLInputElement>) { data.title = e.target.value; }
    function onContentChangeEvent(e: ChangeEvent<HTMLTextAreaElement>) { data.content = e.target.value; }

    return (
        <div className="flex flex-col mx-auto">
            <input className="border-[2px] border-lime-400 w-[800px] outline-none p-1 mb-5" placeholder="제목" readOnly={readOnly} value={data.title} onChange={onTitleChangeEvent}/>
            <textarea className="border-[2px] border-lime-400 w-[800px] outline-none p-1 resize-none h-96" placeholder="내용" readOnly={readOnly} value={data.content} onChange={onContentChangeEvent}/>
        </div>
    )
}

export default Board;
