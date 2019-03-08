<ul id="menu" class="list-group">
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#usermanage_detail"><span>用户管理</span></a>
		<ul class="in" id="usermanage_detail">
			<li class=""><a href="/real_auth_list">平台用户管理</a></li>
			<li class=""><a href="/recharge_offline_list">员工管理</a></li>
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#permissionmanage_detail"><span>安全管理</span></a>
		<ul class="in" id="permissionmanage_detail">
			<li class="systemDictionary"><a href="/systemDictionary_list"><span>系统数据字典目录</span></a></li>
			<li class="systemDictionaryItem"><a href="/systemDictionaryItem_list"><span>系统数据字典明细</span></a></li>
			<li><a href="/permission_list"><span>权限管理</span></a></li>
			<li><a href="#"><span>角色管理</span></a></li>
			<li><a href="#"><span>菜单管理</span></a></li>
			<li class="ipLog"><a href="/ipLog"><span>登录历史</span></a></li>
		</ul>
	</li>
</ul>

<#if currentMenu??>
<script type="text/javascript">
	$(".in li.${currentMenu}").addClass("active");
</script>
</#if>