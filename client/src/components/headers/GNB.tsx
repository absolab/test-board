import { useNavigate } from "react-router-dom";

const GNB = () => {

    const navigate = useNavigate();

    return (
        <div className="flex flex-row">
            <span className="flex min-w-fit mx-5 my-1 justify-center items-center font-bold w-auto lext-lg cursor-pointer" onClick={() => navigate('/')}>Home</span>
            <span className="flex min-w-fit mx-5 my-1 justify-center items-center font-bold w-auto lext-lg cursor-pointer">Guide</span>
        </div>
    )
}

export default GNB;