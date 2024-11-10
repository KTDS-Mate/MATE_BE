document.addEventListener("click", function (e) {
  const isClickedOtherElement =
    e.target.className !== "editable-select-option-div" &&
    e.target.className !== "editable-select-div";
  if (isClickedOtherElement) {
    const options = document.querySelectorAll(".editable-select-option-div");

    if (options) {
      for (const option of options) {
        option.remove();
      }
    }

    const otherSelectDiv = document.querySelectorAll(`.editable-select-div`);
    for (const selectDiv of otherSelectDiv) {
      selectDiv.setAttribute("contenteditable", false);
    }
  } else {
    const otherSelectDiv = document.querySelectorAll(
      `.editable-select-div:not([data-target="${e.target.dataset.target}"])`
    );

    for (const selectDiv of otherSelectDiv) {
      selectDiv.setAttribute("contenteditable", false);
    }
  }
});

function refreshSelector(select) {
  function get(dom = document, selector) {
    return dom.querySelector(selector);
  }

  function getAll(dom = document, selector) {
    return dom.querySelectorAll(selector);
  }

  function setStyle(dom, property, propertyValue) {
    dom.style[property] = propertyValue;
  }

  const itemList = get(
    document,
    `.editable-select-option-div[data-target="${select.className}"]`
  );

  const editableDiv = get(
    document,
    `.editable-select-div[data-target="${select.className}"]`
  );

  select.style.display = "inline-block";
  setStyle(
    editableDiv,
    "min-width",
    "calc(" + (select.offsetWidth || select.width) + "px + 2rem)"
  );
  select.style.display = "none";
  const options = getAll(select, "option");
  editableDiv.innerText = options[0].innerText;
  select.value = options[0].value;
}

function editableSelector(element) {
  if (!element) {
    return;
  }
  const selectors = getAll(document, element);
  if (!selectors) {
    return;
  }

  for (const select of selectors) {
    const editableDiv = makeEditableDiv(select);
    makeFocusEvent(editableDiv, select);
    makeKeyInputEvent(editableDiv, select);
  }

  function get(dom = document, selector) {
    return dom.querySelector(selector);
  }

  function getAll(dom = document, selector) {
    return dom.querySelectorAll(selector);
  }

  function insertAfter(newDom, existsDom) {
    existsDom.parentNode.insertBefore(newDom, existsDom.nextSibling);
  }

  function setStyle(dom, property, propertyValue) {
    dom.style[property] = propertyValue;
  }

  function makeEditableDiv(select) {
    const inputDiv = document.createElement("div");
    inputDiv.className = "editable-select-div";
    inputDiv.dataset.target = select.className;

    setStyle(inputDiv, "position", "relative");
    setStyle(
      inputDiv,
      "min-width",
      "calc(" + (select.offsetWidth || select.width) + "px + 2rem)"
    );

    const options = getAll(select, "option");
    inputDiv.innerText = options[0].innerText;

    insertAfter(inputDiv, select);

    select.style.display = "none";
    return inputDiv;
  }

  function makeFocusEvent(editableDiv, select) {
    editableDiv.addEventListener("click", function () {
      editableDiv.setAttribute("contenteditable", true);
      editableDiv.focus();

      const otherOptions = getAll(document, ".editable-select-option-div");

      for (const otherOption of otherOptions) {
        otherOption.remove();
      }

      const options = getAll(select, "option");
      const optionList = document.createElement("ul");
      optionList.dataset.target = select.className;
      optionList.className = "editable-select-option-div";

      const editableDivPos = {
        top: editableDiv.offsetTop + editableDiv.offsetHeight,
        left: editableDiv.offsetLeft,
      };

      setStyle(optionList, "position", "absolute");
      setStyle(optionList, "left", editableDivPos.left + "px");
      setStyle(optionList, "top", editableDivPos.top + "px");
      setStyle(optionList, "min-width", editableDiv.offsetWidth + "px");

      for (const option of options) {
        const optionItem = document.createElement("li");
        optionItem.dataset.value = option.value;
        optionItem.innerText = option.innerText;

        makeClickOptionEvent(optionItem, editableDiv, select);
        optionList.append(optionItem);
      }

      insertAfter(optionList, editableDiv);
    });
  }

  function makeClickOptionEvent(optionItem, editableDiv, select) {
    optionItem.addEventListener("click", function () {
      const value = this.dataset.value;
      const text = this.innerText;

      editableDiv.innerText = text;
      select.value = value;
      optionItem.parentElement.remove();
    });
  }

  function makeKeyInputEvent(editableDiv, select) {
    editableDiv.addEventListener("keydown", function (e) {
      const itemList = get(
        document,
        `.editable-select-option-div[data-target="${select.className}"]`
      );

      if (itemList) {
        let activeIndex = -1;
        if (itemList.dataset.activeindex) {
          activeIndex = itemList.dataset.activeindex;
        }

        const items = getAll(itemList, "li");
        if (e.key === "ArrowDown") {
          for (const item of items) {
            item.className = "";
          }
          activeIndex++;

          if (activeIndex >= items.length) {
            activeIndex = items.length - 1;
          }

          items[activeIndex].className = "active";
          itemList.dataset.activeindex = activeIndex;
        } else if (e.key === "ArrowUp") {
          for (const item of items) {
            item.className = "";
          }
          activeIndex--;

          if (activeIndex < 0) {
            activeIndex = 0;
          }

          items[activeIndex].className = "active";
          itemList.dataset.activeindex = activeIndex;
        } else if (e.key === "Enter") {
          e.preventDefault();
        }
      }
    });

    editableDiv.addEventListener("keyup", function (e) {
      if (e.key === "ArrowDown" || e.key === "ArrowUp") {
        return;
      }

      const itemList = get(
        document,
        `.editable-select-option-div[data-target="${select.className}"]`
      );

      if (e.key === "Enter") {
        editableDiv.setAttribute("contenteditable", false);
      }

      if (itemList) {
        if (e.key === "Enter") {
          const selectedIndex = itemList.dataset.activeindex;
          if (!selectedIndex || selectedIndex < 0) {
            const selectedValue = select.value;
            const options = getAll(select, "option");

            for (let i = 0; i < options.length; i++) {
              if (selectedValue === options[i].value) {
                editableDiv.innerText = options[i].innerText;
                break;
              }
            }
            itemList.remove();
            return;
          } else {
            getAll(itemList, "li")[selectedIndex].click();
          }
          return;
        }

        itemList.dataset.activeindex = -1;

        const keyword = editableDiv.innerText;
        const itemLength = getAll(itemList, "li").length;
        for (let i = 0; i < itemLength; i++) {
          getAll(itemList, "li")[0].remove();
        }

        const options = getAll(select, "option");
        for (const option of options) {
          if (option.innerText.toLowerCase().includes(keyword.toLowerCase())) {
            const optionItem = document.createElement("li");
            optionItem.dataset.value = option.value;
            optionItem.innerText = option.innerText;

            makeClickOptionEvent(optionItem, editableDiv, select);
            itemList.append(optionItem);
          }
        }
      }
    });
  }
}
