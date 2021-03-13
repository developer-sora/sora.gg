function goDel(a) {
	let ok = confirm("삭제 합니까?");
	if (ok) {
		location.href = "c.del?s_no=" + a;
	}
}