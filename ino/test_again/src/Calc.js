import './css/calc.css';

const Calc = () => {

    const buttons = [
        '1', '2', '3', '+',
        '4', '5', '6', '-',
        '7', '8', '9', '/',
        '0', '=', '.', '*',
        '<=', 'C','(',')'];

    const onClickFuncc = (e) => {
        let inputArea=document.getElementById('input');
        if (e.target.innerHTML === 'C') {
            inputArea.value = '0';
        } else if (e.target.innerText === '<=') {
            if (inputArea.value.length > 1 && inputArea.value !== '0') {
                inputArea.value = inputArea.value.slice(0, inputArea.value.length - 1);
            }
        } else if (e.target.innerHTML === '=') {
            inputArea.value = eval(inputArea.value).toString();
        } else if (inputArea.value === '0') {
            inputArea.value = e.target.innerText;
        } else {
            inputArea.value += e.target.innerText;
        }
    }

    const buttonList = buttons.map((button, index) => {
        return (
            <div className="btn" onClick={(e) =>onClickFuncc(e)}>
                {button}
            </div>)
    });

    return (
        <div id="calc">
            <input type="text" id="input" value='0' readOnly/>
            {buttonList}
        </div>
    );

}
export default Calc;
