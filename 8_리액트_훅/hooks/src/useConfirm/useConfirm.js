const useConfirm = (message = "", callback, onCancel) => {
  if (!callback && typeof callback !== "function") {
    return;
  }
  if (onCancel && typeof onCancel !== "function") {
    return;
  }

  const confirmAction = () => {
    if (confirm(message)) {
      callback();
    } else {
      onCancel();
    }
  };

  return confirmAction;
};
